package com.nnk.springboot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {Trade.class})
class TradeTest {

    private final Trade trade = new Trade("account", "type");
    private final Trade trade1 = new Trade("account", "type");
    private final Trade trade2 = new Trade("account", "type");

    @Test
    void testToString() {
        assertEquals("Trade{tradeId = null, account = 'account', type = 'type', buyQuantity = null, sellQuantity = null, buyPrice = null, sellPrice = null, benchmark = 'null', tradeDate = null, security = 'null', status = 'null', trader = 'null', book = 'null', creationName = 'null', creationDate = null, revisionName = 'null', revisionDate = null, dealName = 'null', dealType = 'null', sourceListId = 'null', side = 'null'}", trade.toString());
    }

    @Test
    void testEquals() {
        trade.setTradeId(1);
        trade1.setTradeId(1);
        trade2.setTradeId(2);
        assertEquals(trade, trade1);
        assertNotEquals(trade, trade2);
    }
}