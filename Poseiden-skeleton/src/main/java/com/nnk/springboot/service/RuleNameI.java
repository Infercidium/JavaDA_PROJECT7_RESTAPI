package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;

import java.util.List;

public interface RuleNameI {
    //Service
    /**
     * Add / Update a ruleName in the database.
     * @param ruleName : to add / update.
     */
    void postRuleName(RuleName ruleName);

    /**
     * Update a ruleName in the database.
     * @param ruleName : to update.
     * @param id : to set id.
     */
    void updateRuleName(RuleName ruleName, Integer id);

    /**
     * Find the ruleName which has the given id.
     * @param id : to find.
     * @return the ruleName.
     */
    RuleName getRuleName(int id);

    /**
     * Find all ruleNames.
     * @return the list of ruleNames.
     */
    List<RuleName> getRuleNames();

    /**
     * Removes the ruleName which has the provided id.
     * @param id : to delete.
     */
    void deleteRuleName(int id);
}
