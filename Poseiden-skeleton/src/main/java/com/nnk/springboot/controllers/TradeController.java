package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeI;
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
public class TradeController {

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(TradeController.class);

    /**
     * Instantiation of tradeInterface.
     */
    @Autowired
    private TradeI tradeS;

    /**
     * Displays the list of trade on the relevant page.
     * @param model : the list to display on the page.
     * @return the html page.
     */
    @RequestMapping("/trade/list")
    public String home(final Model model) {
        model.addAttribute("trades", tradeS.getTrades());
        LOGGER.info("List of Trade Displayed");
        return "trade/list";
    }

    /**
     * Displays the trade add page.
     * @param trade : to add.
     * @return the html page.
     */
    @GetMapping("/trade/add")
    public String addTrade(final Trade trade) {
        LOGGER.debug("Entering the new Trade");
        return "trade/add";
    }

    /**
     * Adds the entered Trade to the database.
     * @param trade : to add.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the trade list if no error, otherwise the add page.
     */
    @PostMapping("/trade/validate")
    public String validate(@Valid final Trade trade,
                           final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            tradeS.postTrade(trade);
            model.addAttribute("trades", tradeS.getTrades());
            LOGGER.info("Trade added");
            return "redirect:/trade/list";
        }
        LOGGER.error("Entry error");
        return "trade/add";
    }

    /**
     * Displays the trade edit page.
     * @param id : trade to modify.
     * @param model : displays the concerned trade.
     * @return the html page.
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        Trade trade = tradeS.getTrade(id);
        model.addAttribute("trade", trade);
        LOGGER.debug("Trade modification");
        return "trade/update";
    }

    /**
     * Modifies the Trade entered the database.
     * @param id : trade to modify.
     * @param trade : modified trade.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the Trade list if no error, otherwise the modification page.
     */
    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") final Integer id,
                              @Valid final Trade trade,
                             final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "trade/update";
        }
        tradeS.updateTrade(trade, id);
        model.addAttribute("trades", tradeS.getTrades());
        LOGGER.info("Modified trade");
        return "redirect:/trade/list";
    }

    /**
     * Removes the selected Trade from the database.
     * @param id : trade to delete.
     * @param model : the list to display on the next page.
     * @return the list of trade.
     */
    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") final Integer id,
                              final Model model) {
        tradeS.deleteTrade(id);
        model.addAttribute("trades", tradeS.getTrades());
        LOGGER.info("Trade delete");
        return "redirect:/trade/list";
    }
}
