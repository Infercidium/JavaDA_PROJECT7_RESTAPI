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

    private static final Logger LOGGER
            = LoggerFactory.getLogger(RuleNameService.class);

    @Autowired
    private RuleNameRepository ruleNameR;

    //Service
    @Override
    public void postRuleName(final RuleName ruleName) {
        ruleNameR.save(ruleName);
        LOGGER.debug("RuleName save");
    }

    @Override
    public RuleName getRuleName(final int id) {
        LOGGER.debug("RuleName found");
        return ruleNameR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid ruleName Id:" + id));
    }

    @Override
    public List<RuleName> getRuleNames() {
        LOGGER.debug("RuleNames found");
        return ruleNameR.findAll();
    }

    @Override
    public void deleteRuleName(final int id) {
        RuleName ruleName = getRuleName(id);
        ruleNameR.delete(ruleName);
        LOGGER.debug("RuleName remove");
    }
}
