package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {LoginController.class})
class LoginControllerTest {

    @MockBean
    private UserService userS;

    @Autowired
    private LoginController loginC;

    private final User user = new User(1, "username", "Password1*", "fullname", "role");

    @Test
    void login() {
        ModelAndView result1 = loginC.login();
        assertEquals("ModelAndView [view=\"login\"; model=null]", result1.toString());
    }

    @Test
    void getAllUserArticles() {
        when(userS.getUsers()).thenReturn(Collections.singletonList(user));
        ModelAndView result2 = loginC.getAllUserArticles();
        assertEquals("ModelAndView [view=\"user/list\"; model={users=[User{id = 1, username = 'username', password = 'Password1*', fullname = 'fullname', role = 'role'}]}]", result2.toString());
    }

    @Test
    void error() {
        ModelAndView result3 = loginC.error();
        assertEquals("ModelAndView [view=\"403\"; model={errorMsg=You are not authorized for the requested data.}]", result3.toString());
    }
}