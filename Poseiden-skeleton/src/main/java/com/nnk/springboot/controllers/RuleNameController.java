package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RuleNameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuleNameController.class);

    @Autowired
    private RuleNameI ruleNameS;

    @RequestMapping("/ruleName/list")
    public String home(final Model model) {
        model.addAttribute("ruleNames", ruleNameS.getRuleNames());
        LOGGER.info("List of RuleName displayed");
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(final RuleName bid) {
        LOGGER.debug("Entering the new RuleName");
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid final RuleName ruleName, final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            ruleNameS.postRuleName(ruleName);
            model.addAttribute("ruleNames", ruleNameS.getRuleNames());
            LOGGER.info("RuleName added");
            return "redirect:/ruleName/list";
        }
        LOGGER.error("Entry error");
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id, final Model model) {
        RuleName ruleName = ruleNameS.getRuleName(id);
        model.addAttribute("ruleName", ruleName);
        LOGGER.debug("Changing the RuleName");
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") final Integer id, @Valid final RuleName ruleName,
                             final BindingResult result, Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "ruleName/update";
        }
        ruleName.setId(id);
        ruleNameS.postRuleName(ruleName);
        model.addAttribute("ruleNames", ruleNameS.getRuleNames());
        LOGGER.info("RuleName changed");
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") final Integer id, final Model model) {
        ruleNameS.deleteRuleName(id);
        model.addAttribute("ruleNames", ruleNameS.getRuleNames());
        LOGGER.info("RuleName deleted");
        return "redirect:/ruleName/list";
    }
}
