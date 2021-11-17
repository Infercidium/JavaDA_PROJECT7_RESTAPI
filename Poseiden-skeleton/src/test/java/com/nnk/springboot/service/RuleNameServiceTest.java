package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        ruleName.setId(1);

        when(ruleNameR.findById(isA(Integer.class))).thenAnswer(new Answer<Optional<RuleName>>() {
            /**
             * @param invocation the invocation on the mock.
             * @return the value to be returned
             */
            @Override
            public Optional<RuleName> answer(InvocationOnMock invocation) {
                Integer integer = invocation.getArgument(0, Integer.class);
                if (integer == 0) {
                    return Optional.empty();
                }
                return Optional.of(ruleName);
            }
        });
    }

    @Test
    void postRuleName() {
        ruleNameS.postRuleName(ruleName);
        verify(ruleNameR, times(1)).save(ruleName);
    }

    @Test
    void updateRuleName() {
        ruleNameS.updateRuleName(ruleName, 1);
        verify(ruleNameR, times(1)).save(ruleName);
        assertEquals(1, ruleName.getId());
    }

    @Test
    void getRuleName() {
        RuleName ruleNameResult = ruleNameS.getRuleName(1);
        assertEquals(ruleName ,ruleNameResult);
    }

    @Test
    void getRuleNameFail() {
        assertThrows(IllegalArgumentException.class, ()->ruleNameS.getRuleName(0));
    }

    @Test
    void getRuleNames() {
        when(ruleNameR.findAll()).thenReturn(Collections.singletonList(ruleName));
        List<RuleName> ruleNameList = ruleNameS.getRuleNames();
        assertEquals(Collections.singletonList(ruleName), ruleNameList);
    }

    @Test
    void deleteRuleName() {
        ruleNameS.deleteRuleName(1);
        verify(ruleNameR, times(1)).delete(ruleName);
    }
}