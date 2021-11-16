package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {BidListController.class})
class BidListControllerTest {

    @MockBean
    private BidListService bidListS;

    @MockBean
    private Model model;

    @MockBean
    private BindingResult result;

    @Autowired
    private BidListController bidListC;

    private final BidList bidList = new BidList("account", "type", 2.00);

    @BeforeEach
    void setUp() {
        when(bidListS.getBidList(isA(Integer.class))).thenReturn(bidList);
    }

    @Test
    void home() {
        String result1 = bidListC.home(model);
        assertEquals("bidList/list", result1);
    }

    @Test
    void addBidForm() {
        String result2 = bidListC.addBidForm(bidList);
        assertEquals("bidList/add", result2);
    }

    @Test
    void validate() {
        when(result.hasErrors()).thenReturn(false);
        String result3 = bidListC.validate(bidList, result, model);
        assertEquals("redirect:/bidList/list", result3);
    }

    @Test
    void validateFail() {
        when(result.hasErrors()).thenReturn(true);
        String result32 = bidListC.validate(bidList, result, model);
        assertEquals("bidList/add", result32);
    }

    @Test
    void showUpdateForm() {
        String result4 = bidListC.showUpdateForm(isA(Integer.class), model);
        assertEquals("bidList/update", result4);
    }

    @Test
    void updateBid() {
        when(result.hasErrors()).thenReturn(false);
        String result5 = bidListC.updateBid(1, bidList, result, model);
        assertEquals("redirect:/bidList/list", result5);
    }

    @Test
    void updateBidFail() {
        when(result.hasErrors()).thenReturn(true);
        String result52 = bidListC.updateBid(1, bidList, result, model);
        assertEquals("bidList/update", result52);
    }

    @Test
    void deleteBid() {
        String result6 = bidListC.deleteBid(isA(Integer.class), model);
        assertEquals("redirect:/bidList/list", result6);
    }
}