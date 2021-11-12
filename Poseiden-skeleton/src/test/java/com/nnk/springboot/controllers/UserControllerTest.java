package com.nnk.springboot.controllers;

import com.nnk.springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserController.class})
class UserControllerTest {

    @MockBean
    private UserService userS;

    @Autowired
    private UserController userC;

    @BeforeEach
    void setUp() {

    }

    @Test
    void home() {
    }

    @Test
    void addUser() {
    }

    @Test
    void validate() {
    }

    @Test
    void showUpdateForm() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}