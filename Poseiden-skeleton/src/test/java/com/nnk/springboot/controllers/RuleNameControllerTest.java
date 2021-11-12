package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;
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

@SpringBootTest(classes = {RuleNameController.class})
class RuleNameControllerTest {

    @MockBean
    private RuleNameService ruleNameS;

    @MockBean
    private Model model;

    @MockBean
    private BindingResult result;

    @Autowired
    private RuleNameController ruleNameC;

    RuleName ruleName = new RuleName("name", "description", "json", "template", "sqlStr", "sqlPart");

    @BeforeEach
    void setUp() {
        when(ruleNameS.getRuleName(isA(Integer.class))).thenReturn(ruleName);
    }

    @Test
    void home() {
        String result1 = ruleNameC.home(model);
        assertEquals("ruleName/list", result1);
    }

    @Test
    void addRuleForm() {
        String result2 = ruleNameC.addRuleForm(ruleName);
        assertEquals("ruleName/add", result2);
    }

    @Test
    void validate() {
        when(result.hasErrors()).thenReturn(false);
        String result3 = ruleNameC.validate(ruleName, result, model);
        assertEquals("redirect:/ruleName/list", result3);
    }

    @Test
    void validateFail() {
        when(result.hasErrors()).thenReturn(true);
        String result32 = ruleNameC.validate(ruleName, result, model);
        assertEquals("ruleName/add", result32);
    }

    @Test
    void showUpdateForm() {
        String result4 = ruleNameC.showUpdateForm(isA(Integer.class), model);
        assertEquals("ruleName/update", result4);
    }

    @Test
    void updateRuleName() {
        when(result.hasErrors()).thenReturn(false);
        String result5 = ruleNameC.updateRuleName(1, ruleName, result, model);
        assertEquals("redirect:/ruleName/list", result5);
    }

    @Test
    void updateRuleNameFail() {
        when(result.hasErrors()).thenReturn(true);
        String result52 = ruleNameC.updateRuleName(1, ruleName, result, model);
        assertEquals("ruleName/update", result52);
    }

    @Test
    void deleteRuleName() {
        String result6 = ruleNameC.deleteRuleName(isA(Integer.class), model);
        assertEquals("redirect:/ruleName/list", result6);
    }
}