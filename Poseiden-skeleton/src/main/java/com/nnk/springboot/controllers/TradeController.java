package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeI;
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

    @Autowired
    private TradeI tradeS;

    @RequestMapping("/trade/list")
    public String home(final Model model) {
        model.addAttribute("trades", tradeS.getTrades());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(final Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid final Trade trade, final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            tradeS.postTrade(trade);
            model.addAttribute("trades", tradeS.getTrades());
            return "redirect:/trade/list";
        }
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id, final Model model) {
        Trade trade = tradeS.getTrade(id);
        model.addAttribute("trade", trade);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") final Integer id, @Valid final Trade trade,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "trade/update";
        }
        trade.setTradeId(id);
        tradeS.postTrade(trade);
        model.addAttribute("trades", tradeS.getTrades());
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") final Integer id, final Model model) {
        tradeS.deleteTrade(id);
        model.addAttribute("trades", tradeS.getTrades());
        return "redirect:/trade/list";
    }
}
