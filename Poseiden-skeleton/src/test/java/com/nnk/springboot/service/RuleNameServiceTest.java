package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {RuleNameService.class})
class RuleNameServiceTest {

    @MockBean
    private RuleNameRepository ruleNameR;

    @Autowired
    private RuleNameService ruleNameS;

    private final RuleName ruleName = new RuleName("name", "description", "json", "template", "sqlStr", "sqlPart");

    @BeforeEach
    void setUp() {
        when(ruleNameR.findById(isA(Integer.class))).thenReturn(java.util.Optional.of(ruleName));
    }

    @Test
    void postRuleName() {
        ruleNameS.postRuleName(ruleName);
        verify(ruleNameR, times(1)).save(ruleName);
    }

    @Test
    void updateRuleName() {
        ruleNameS.updateRuleName(ruleName, 2);
        verify(ruleNameR, times(1)).save(ruleName);
        assertEquals(2, ruleName.getId());
    }

    @Test
    void getRuleName() {
        RuleName ruleNameResult = ruleNameS.getRuleName(isA(Integer.class));
        assertEquals(ruleName ,ruleNameResult);
    }

    @Test
    void getRuleNames() {
        when(ruleNameR.findAll()).thenReturn(Collections.singletonList(ruleName));
        List<RuleName> ruleNameList = ruleNameS.getRuleNames();
        assertEquals(Collections.singletonList(ruleName), ruleNameList);
    }

    @Test
    void deleteRuleName() {
        ruleNameS.deleteRuleName(isA(Integer.class));
        verify(ruleNameR, times(1)).delete(ruleName);
    }
}