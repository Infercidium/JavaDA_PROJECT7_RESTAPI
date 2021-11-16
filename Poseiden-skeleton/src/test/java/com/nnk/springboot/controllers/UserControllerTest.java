package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserController.class})
class UserControllerTest {

    @MockBean
    private UserService userS;

    @MockBean
    private Model model;

    @MockBean
    private BindingResult result;

    @Autowired
    private UserController userC;

    private final User user = new User(1, "username", "Password1*", "fullname", "role");

    @BeforeEach
    void setUp() {
        when(userS.getUser(isA(Integer.class))).thenReturn(user);
    }

    @Test
    void home() {
        String result1 = userC.home(model);
        assertEquals("user/list", result1);
    }

    @Test
    void addUser() {
        String result2 = userC.addUser(user);
        assertEquals("user/add", result2);
    }

    @Test
    void validate() {
        when(result.hasErrors()).thenReturn(false);
        String result3 = userC.validate(user, result, model);
        assertEquals("redirect:/user/list", result3);
    }

    @Test
    void validateFail() {
        when(result.hasErrors()).thenReturn(true);
        String result32 = userC.validate(user, result, model);
        assertEquals("user/add", result32);
    }

    @Test
    void showUpdateForm() {
        String result4 = userC.showUpdateForm(isA(Integer.class), model);
        assertEquals("user/update", result4);
    }

    @Test
    void updateUser() {
        when(result.hasErrors()).thenReturn(false);
        String result5 = userC.updateUser(1, user, result, model);
        assertEquals("redirect:/user/list", result5);
    }

    @Test
    void updateUserFail() {
        when(result.hasErrors()).thenReturn(true);
        String result52 = userC.updateUser(1, user, result, model);
        assertEquals("user/update", result52);
    }

    @Test
    void deleteUser() {
        String result6 = userC.deleteUser(isA(Integer.class), model);
        assertEquals("redirect:/user/list", result6);
    }
}