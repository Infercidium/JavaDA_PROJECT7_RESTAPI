package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        when(userR.findById(isA(Integer.class))).thenAnswer(new Answer<Optional<User>>() {
            /**
             * @param invocation the invocation on the mock.
             * @return the value to be returned
             */
            @Override
            public Optional<User> answer(InvocationOnMock invocation) {
                Integer integer = invocation.getArgument(0, Integer.class);
                if (integer == 0) {
                    return Optional.empty();
                }
                return Optional.of(user);
            }
        });
    }

    @Test
    void postUser() {
        userS.postUser(user);
        verify(userR, times(1)).save(user);
    }

    @Test
    void updateUser() {
        userS.updateUser(user, 2);
        verify(userR, times(1)).save(user);
        assertEquals(2, user.getId());
    }

    @Test
    void getUser() {
        User userResult = userS.getUser(1);
        assertEquals(user, userResult);
    }

    @Test
    void getUserFail() {
        assertThrows(IllegalArgumentException.class, ()->userS.getUser(0));
    }

    @Test
    void getUsers() {
        when(userR.findAll()).thenReturn(Collections.singletonList(user));
        List<User> userList = userS.getUsers();
        assertEquals(Collections.singletonList(user), userList);
    }

    @Test
    void deleteUser() {
        userS.deleteUser(1);
        verify(userR, times(1)).delete(user);
    }

    @Test
    void loadUserByUsername() {
        when(userR.findByUsernameIgnoreCase(user.getUsername())).thenReturn(user);
        UserDetails result  = userS.loadUserByUsername(user.getUsername());
        assertEquals(userDetail, result);
    }
}