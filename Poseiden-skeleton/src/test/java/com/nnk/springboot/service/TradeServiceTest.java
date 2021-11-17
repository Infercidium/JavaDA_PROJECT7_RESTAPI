package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {TradeService.class})
class TradeServiceTest {

    @MockBean
    private TradeRepository tradeR;

    @Autowired
    private TradeService tradeS;

    private final Trade trade = new Trade("account", "type");

    @BeforeEach
    void setUp() {
        when(tradeR.findById(isA(Integer.class))).thenReturn(java.util.Optional.of(trade));
    }

    @Test
    void postTrade() {
        tradeS.postTrade(trade);
        verify(tradeR,times(1)).save(trade);
    }

    @Test
    void updateTrade() {
        tradeS.updateTrade(trade, 2);
        verify(tradeR,times(1)).save(trade);
        assertEquals(2, trade.getTradeId());
    }

    @Test
    void getTrade() {
        Trade tradeResult = tradeS.getTrade(isA(Integer.class));
        assertEquals(trade, tradeResult);
    }

    @Test
    void getTrades() {
        when(tradeR.findAll()).thenReturn(Collections.singletonList(trade));
        List<Trade> tradeList = tradeS.getTrades();
        assertEquals(Collections.singletonList(trade), tradeList);
    }

    @Test
    void deleteTrade() {
        tradeS.deleteTrade(isA(Integer.class));
        verify(tradeR, times(1)).delete(trade);
    }
}