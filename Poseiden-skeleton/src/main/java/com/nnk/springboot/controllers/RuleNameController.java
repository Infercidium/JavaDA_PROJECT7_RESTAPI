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

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(RuleNameController.class);

    /**
     * Instantiation of ruleNameInterface.
     */
    @Autowired
    private RuleNameI ruleNameS;

    /**
     * Displays the list of ruleName on the relevant page.
     * @param model : the list to display on the page.
     * @return the html page.
     */
    @RequestMapping("/ruleName/list")
    public String home(final Model model) {
        model.addAttribute("ruleNames", ruleNameS.getRuleNames());
        LOGGER.info("List of RuleName displayed");
        return "ruleName/list";
    }

    /**
     * Displays the ruleName add page.
     * @param ruleName : to add.
     * @return the html page.
     */
    @GetMapping("/ruleName/add")
    public String addRuleForm(final RuleName ruleName) {
        LOGGER.debug("Entering the new RuleName");
        return "ruleName/add";
    }

    /**
     * Adds the entered RuleName to the database.
     * @param ruleName : to add.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the ruleName list if no error, otherwise the add page.
     */
    @PostMapping("/ruleName/validate")
    public String validate(@Valid final RuleName ruleName,
                           final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            ruleNameS.postRuleName(ruleName);
            model.addAttribute("ruleNames", ruleNameS.getRuleNames());
            LOGGER.info("RuleName added");
            return "redirect:/ruleName/list";
        }
        LOGGER.error("Entry error");
        return "ruleName/add";
    }

    /**
     * Displays the ruleName edit page.
     * @param id : ruleName to modify.
     * @param model : displays the concerned ruleName.
     * @return the html page.
     */
    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        RuleName ruleName = ruleNameS.getRuleName(id);
        model.addAttribute("ruleName", ruleName);
        LOGGER.debug("Changing the RuleName");
        return "ruleName/update";
    }

    /**
     * Modifies the RuleName entered the database.
     * @param id : ruleName to modify.
     * @param ruleName : modified ruleName.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the RuleName list if no error, otherwise the modification page.
     */
    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") final Integer id,
                                 @Valid final RuleName ruleName,
                             final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "ruleName/update";
        }
        ruleNameS.updateRuleName(ruleName, id);
        model.addAttribute("ruleNames", ruleNameS.getRuleNames());
        LOGGER.info("RuleName changed");
        return "redirect:/ruleName/list";
    }

    /**
     * Removes the selected RuleName from the database.
     * @param id : ruleName to delete.
     * @param model : the list to display on the next page.
     * @return the list of ruleName.
     */
    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") final Integer id,
                                 final Model model) {
        ruleNameS.deleteRuleName(id);
        model.addAttribute("ruleNames", ruleNameS.getRuleNames());
        LOGGER.info("RuleName deleted");
        return "redirect:/ruleName/list";
    }
}
