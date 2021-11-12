package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserService.class})
class UserServiceTest {

    @MockBean
    private UserRepository userR;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userS;

    private final User user = new User(1, "username", "Password1*", "fullname", "role");
    private final org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));

    @BeforeEach
    void setUp() {
        when(userR.findById(isA(Integer.class))).thenReturn(java.util.Optional.of(user));
    }

    @Test
    void postUser() {
        userS.postUser(user);
        verify(userR, times(1)).save(user);
    }

    @Test
    void getUser() {
        User userResult = userS.getUser(isA(Integer.class));
        assertEquals(user, userResult);
    }

    @Test
    void getUsers() {
        when(userR.findAll()).thenReturn(Collections.singletonList(user));
        List<User> userList = userS.getUsers();
        assertEquals(Collections.singletonList(user), userList);
    }

    @Test
    void deleteUser() {
        userS.deleteUser(isA(Integer.class));
        verify(userR, times(1)).delete(user);
    }

    @Test
    void loadUserByUsername() {
        when(userR.findByUsernameIgnoreCase(user.getUsername())).thenReturn(user);
        UserDetails result  = userS.loadUserByUsername(user.getUsername());
        assertEquals(userDetail, result);
    }
}