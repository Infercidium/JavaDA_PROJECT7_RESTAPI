package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        trade.setTradeId(1);

        when(tradeR.findById(isA(Integer.class))).thenReturn(java.util.Optional.of(trade));
        when(tradeR.findById(isA(Integer.class))).thenAnswer(new Answer<Optional<Trade>>() {
            /**
             * @param invocation the invocation on the mock.
             * @return the value to be returned
             */
            @Override
            public Optional<Trade> answer(InvocationOnMock invocation) {
                Integer integer = invocation.getArgument(0, Integer.class);
                if (integer == 0) {
                    return Optional.empty();
                }
                return Optional.of(trade);
            }
        });
    }

    @Test
    void postTrade() {
        tradeS.postTrade(trade);
        verify(tradeR,times(1)).save(trade);
    }

    @Test
    void updateTrade() {
        tradeS.updateTrade(trade, 1);
        verify(tradeR,times(1)).save(trade);
        assertEquals(1, trade.getTradeId());
    }

    @Test
    void getTrade() {
        Trade tradeResult = tradeS.getTrade(1);
        assertEquals(trade, tradeResult);
    }

    @Test
    void getTradeFail() {
        assertThrows(IllegalArgumentException.class, ()->tradeS.getTrade(0));
    }

    @Test
    void getTrades() {
        when(tradeR.findAll()).thenReturn(Collections.singletonList(trade));
        List<Trade> tradeList = tradeS.getTrades();
        assertEquals(Collections.singletonList(trade), tradeList);
    }

    @Test
    void deleteTrade() {
        tradeS.deleteTrade(1);
        verify(tradeR, times(1)).delete(trade);
    }
}