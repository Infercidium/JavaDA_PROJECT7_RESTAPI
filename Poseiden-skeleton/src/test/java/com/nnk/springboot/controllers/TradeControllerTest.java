package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
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

@SpringBootTest(classes = {TradeController.class})
class TradeControllerTest {

    @MockBean
    private TradeService tradeS;

    @MockBean
    private Model model;

    @MockBean
    private BindingResult result;

    @Autowired
    private TradeController tradeC;

    private final Trade trade = new Trade("account", "type");

    @BeforeEach
    void setUp() {
        when(tradeS.getTrade(isA(Integer.class))).thenReturn(trade);
    }

    @Test
    void home() {
        String result1 = tradeC.home(model);
        assertEquals("trade/list", result1);
    }

    @Test
    void addTrade() {
        String result2 = tradeC.addTrade(trade);
        assertEquals("trade/add", result2);
    }

    @Test
    void validate() {
        when(result.hasErrors()).thenReturn(false);
        String result3 = tradeC.validate(trade, result, model);
        assertEquals("redirect:/trade/list", result3);
    }

    @Test
    void validateFail() {
        when(result.hasErrors()).thenReturn(true);
        String result32 = tradeC.validate(trade, result, model);
        assertEquals("trade/add", result32);
    }

    @Test
    void showUpdateForm() {
        String result4 = tradeC.showUpdateForm(isA(Integer.class), model);
        assertEquals("trade/update", result4);
    }

    @Test
    void updateTrade() {
        when(result.hasErrors()).thenReturn(false);
        String result5 = tradeC.updateTrade(1, trade, result, model);
        assertEquals("redirect:/trade/list", result5);
    }

    @Test
    void updateTradeFail() {
        when(result.hasErrors()).thenReturn(true);
        String result52 = tradeC.updateTrade(1, trade, result, model);
        assertEquals("trade/update", result52);
    }

    @Test
    void deleteTrade() {
        String result6 = tradeC.deleteTrade(isA(Integer.class), model);
        assertEquals("redirect:/trade/list", result6);
    }
}