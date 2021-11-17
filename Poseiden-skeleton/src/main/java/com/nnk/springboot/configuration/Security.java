package com.nnk.springboot.configuration;

import com.nnk.springboot.service.UserI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableJpaAuditing
public class Security extends WebSecurityConfigurerAdapter
        implements AuditorAware<String> {

    /**
     * Instantiation of userInterface.
     */
    @Autowired
    private UserI userS;

    /**
     * Password encoding bean.
     * @return the password encoder.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Authentication Bean.
     * @return program authentication.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userS);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    /**
     * Authentication configuration.
     * @param auth : program authentication.
     */
    @Override
    public void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Configuration of access to the program's html.
     * @param http used in configuration.
     * @throws Exception global.
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/bootstrap.min.css")
                    .permitAll()
                .anyRequest().authenticated()
                    .and().oauth2Login()
                        .defaultSuccessUrl("/bidList/list").permitAll()
                    .and().formLogin()
                        .defaultSuccessUrl("/bidList/list").permitAll()
                    .and().logout()
                        .invalidateHttpSession(true).clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .logoutRequestMatcher(
                                new AntPathRequestMatcher("/app-logout"))
                        .permitAll();
    }

    //Audit
    /**
     * Allows specifying which User to create or modify an entity.
     * @return Username of the logged-in User.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        String name = "System";
        if (SecurityContextHolder.getContext()
                .getAuthentication().isAuthenticated()) {
            name = SecurityContextHolder.getContext()
                    .getAuthentication().getName();
        }
        return Optional.ofNullable(name);
    }
}
