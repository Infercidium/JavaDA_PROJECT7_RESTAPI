package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListI;
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
public class BidListController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(BidListController.class);

    @Autowired
    private BidListI bidListS;

    @RequestMapping("/bidList/list")
    public String home(final Model model) {
        model.addAttribute("bidLists", bidListS.getBidLists());
        LOGGER.info("Bid list displayed");
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(final BidList bid) {
        LOGGER.debug("Entering the new Bid");
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid final BidList bid,
                           final BindingResult result,
                           final Model model) {
        if (!result.hasErrors()) {
            bidListS.postBidList(bid);
            model.addAttribute("bidLists", bidListS.getBidLists());
            LOGGER.info("Bid added");
            return "redirect:/bidList/list";
        }
        LOGGER.error("Entry error");
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        BidList bidList = bidListS.getBidList(id);
        model.addAttribute("bidList", bidList);
        LOGGER.debug("Modification of the Bid");
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") final Integer id,
                            @Valid final BidList bidList,
                             final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "bidList/update";
        }
        bidList.setBidListId(id);
        bidListS.postBidList(bidList);
        model.addAttribute("bidLists", bidListS.getBidLists());
        LOGGER.info("Bid modified");
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") final Integer id,
                            final Model model) {
        bidListS.deleteBidList(id);
        model.addAttribute("bidLists", bidListS.getBidLists());
        LOGGER.info("Bid deleted");
        return "redirect:/bidList/list";
    }
}
