package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserI {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userR;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Service
    @Override
    public void postUser(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userR.save(user);
        LOGGER.debug("User Save");
    }

    @Override
    public User getUser(final int id) {
        LOGGER.debug("User found");
        return userR.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    @Override
    public List<User> getUsers() {
        LOGGER.debug("Users found");
        return userR.findAll();
    }

    @Override
    public void deleteUser(final int id) {
        User user = getUser(id);
        userR.delete(user);
        LOGGER.debug("User remove");
    }

    // UserDetailsService
    /**
     * Load User security from the Username of a User model.
     * @param username research.
     * @return User of Security Springframework.
     * @throws UsernameNotFoundException if Username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userR.findByUsernameIgnoreCase(username);
        if (user == null) {
            throw  new UsernameNotFoundException("Could not find user");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    }

    /**
     * Used by loadUserByUsername.
     * @param authority : role like User or Admin.
     * @return Authorities.
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(final String authority) {
        return Collections.singleton(new SimpleGrantedAuthority(authority));
    }
}
