package com.nnk.springboot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {BidList.class})
class BidListTest {

    private final BidList bidList = new BidList("account", "type", 2.00);
    private final BidList bidList1 = new BidList("account", "type", 2.01);
    private final BidList bidList2 = new BidList("account", "type", 2.00);

    @Test
    void testToString() {
        assertEquals("BidList{bidListId = null, account = 'account', type = 'type', bidQuantity = 2.0, askQuantity = null, bid = null, ask = null, benchmark = 'null', bidListDate = null, commentary = 'null', security = 'null', status = 'null', trader = 'null', book = 'null', creationName = 'null', creationDate = null, revisionName = 'null', revisionDate = null, dealName = 'null', dealType = 'null', sourceListId = 'null', side = 'null'}", bidList.toString());
    }

    @Test
    void testEquals() {
        bidList.setBidListId(1);
        bidList1.setBidListId(2);
        bidList2.setBidListId(1);
        assertEquals(bidList, bidList2);
        assertNotEquals(bidList, bidList1);
    }
}