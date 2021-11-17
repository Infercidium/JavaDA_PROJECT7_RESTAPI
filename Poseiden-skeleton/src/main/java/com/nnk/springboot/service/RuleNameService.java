package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameService implements RuleNameI {

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(RuleNameService.class);

    /**
     * Instantiation of ruleNameRepository.
     */
    @Autowired
    private RuleNameRepository ruleNameR;

    //Service

    /**
     * Add a ruleName in the database.
     * @param ruleName : to add.
     */
    @Override
    public void postRuleName(final RuleName ruleName) {
        ruleNameR.save(ruleName);
        LOGGER.debug("RuleName save");
    }

    /**
     * Update a ruleName in the database.
     * @param ruleName : to update.
     * @param id : to set id.
     */
    @Override
    public void updateRuleName(final RuleName ruleName, final Integer id) {
        ruleName.setId(id);
        ruleNameR.save(ruleName);
        LOGGER.debug("RuleName save");
    }

    /**
     * Find the ruleName which has the given id.
     * @param id : to find.
     * @return the ruleName.
     */
    @Override
    public RuleName getRuleName(final int id) {
        LOGGER.debug("RuleName found");
        return ruleNameR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid ruleName Id:" + id));
    }

    /**
     * Find all ruleNames.
     * @return the list of ruleNames.
     */
    @Override
    public List<RuleName> getRuleNames() {
        LOGGER.debug("RuleNames found");
        return ruleNameR.findAll();
    }

    /**
     * Removes the ruleName which has the provided id.
     * @param id : to delete.
     */
    @Override
    public void deleteRuleName(final int id) {
        RuleName ruleName = getRuleName(id);
        ruleNameR.delete(ruleName);
        LOGGER.debug("RuleName remove");
    }
}
