package com.nnk.springboot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {RuleName.class})
class RuleNameTest {

    private final RuleName ruleName = new RuleName("name", "description", "json", "template", "sqlStr", "sqlPart");
    private final RuleName ruleName1 = new RuleName("name", "description", "json", "template", "sqlStr", "sqlPart");
    private final RuleName ruleName2 = new RuleName("name", "description", "json", "template", "sqlStr", "sqlPart");

    @Test
    void testToString() {
        assertEquals("RuleName{id = null, name = 'name', description = 'description', json = 'json', template = 'template', sqlStr = 'sqlStr', sqlPart = 'sqlPart'}", ruleName.toString());
    }

    @Test
    void testEquals() {
        ruleName.setId(1);
        ruleName1.setId(1);
        ruleName2.setId(2);
        assertEquals(ruleName, ruleName1);
        assertNotEquals(ruleName, ruleName2);
    }
}