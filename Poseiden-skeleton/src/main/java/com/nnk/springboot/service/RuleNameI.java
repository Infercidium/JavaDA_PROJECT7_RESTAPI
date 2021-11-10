package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;

import java.util.List;

public interface RuleNameI {
    //Service
    void postRuleName(RuleName ruleName);

    RuleName getRuleName(int id);

    List<RuleName> getRuleNames();

    void deleteRuleName(int id);
}
