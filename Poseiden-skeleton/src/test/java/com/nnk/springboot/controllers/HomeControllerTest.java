package com.nnk.springboot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {HomeController.class})
class HomeControllerTest {

    @MockBean
    private Model model;

    @Autowired
    private HomeController homeC;

    @Test
    void home() {
        String result1 = homeC.home(model);
        assertEquals("home", result1);
    }

    @Test
    void adminHome() {
        String result2 = homeC.adminHome(model);
        assertEquals("redirect:/bidList/list", result2);
    }
}