package com.nnk.springboot.controllers;

import com.nnk.springboot.service.RuleNameService;
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

@SpringBootTest(classes = {RuleNameController.class})
class RuleNameControllerTest {

    @MockBean
    private RuleNameService ruleNameS;

    @Autowired
    private RuleNameController ruleNameC;

    @BeforeEach
    void setUp() {

    }

    @Test
    void home() {
    }

    @Test
    void addRuleForm() {
    }

    @Test
    void validate() {
    }

    @Test
    void showUpdateForm() {
    }

    @Test
    void updateRuleName() {
    }

    @Test
    void deleteRuleName() {
    }
}