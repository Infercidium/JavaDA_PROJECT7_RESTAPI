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

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(BidListController.class);

    /**
     * Instantiation of bidListInterface.
     */
    @Autowired
    private BidListI bidListS;

    /**
     * Displays the list of bidList on the relevant page.
     * @param model : the list to be displayed on the page.
     * @return the html page.
     */
    @RequestMapping("/bidList/list")
    public String home(final Model model) {
        model.addAttribute("bidLists", bidListS.getBidLists());
        LOGGER.info("Bid list displayed");
        return "bidList/list";
    }

    /**
     * Displays the bidList add page.
     * @param bid : to add.
     * @return the html page.
     */
    @GetMapping("/bidList/add")
    public String addBidForm(final BidList bid) {
        LOGGER.debug("Entering the new Bid");
        return "bidList/add";
    }

    /**
     * Adds the entered Bid to the database.
     * @param bid : to add.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the list of bidList if no error, otherwise the add page.
     */
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

    /**
     * Displays the bidList edit page.
     * @param id : bid to modify.
     * @param model : displays the concerned bid.
     * @return the html page.
     */
    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        BidList bidList = bidListS.getBidList(id);
        model.addAttribute("bidList", bidList);
        LOGGER.debug("Modification of the Bid");
        return "bidList/update";
    }

    /**
     * Modifies the Bid entered the database.
     * @param id : bid to modify.
     * @param bidList : modified bid.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the list of bidList if no error,
     *         otherwise the modification page.
     */
    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") final Integer id,
                            @Valid final BidList bidList,
                             final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "bidList/update";
        }
        bidListS.updateBidList(bidList, id);
        model.addAttribute("bidLists", bidListS.getBidLists());
        LOGGER.info("Bid modified");
        return "redirect:/bidList/list";
    }

    /**
     * Removes the selected Bid from the database.
     * @param id : bid to delete.
     * @param model : the list to display on the next page.
     * @return the list of bidList.
     */
    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") final Integer id,
                            final Model model) {
        bidListS.deleteBidList(id);
        model.addAttribute("bidLists", bidListS.getBidLists());
        LOGGER.info("Bid deleted");
        return "redirect:/bidList/list";
    }
}
