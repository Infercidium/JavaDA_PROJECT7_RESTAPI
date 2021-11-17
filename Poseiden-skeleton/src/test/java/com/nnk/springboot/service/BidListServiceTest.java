package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
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

@SpringBootTest(classes = {BidListService.class})
class BidListServiceTest {

    @MockBean
    private BidListRepository bidListR;

    @Autowired
    private BidListService bidListS;

    private final BidList bidList = new BidList("account", "type", 2.00);

    @BeforeEach
    void setUp() {
        when(bidListR.findById(isA(Integer.class))).thenReturn(java.util.Optional.of(bidList));
    }

    @Test
    void postBidList() {
        bidListS.postBidList(bidList);
        verify(bidListR, times(1)).save(bidList);
    }

    @Test
    void updateBidList() {
        bidListS.updateBidList(bidList, 2);
        verify(bidListR, times(1)).save(bidList);
        assertEquals(2, bidList.getBidListId());
    }

    @Test
    void getBidList() {
        BidList bidListResult = bidListS.getBidList(isA(Integer.class));
        assertEquals(bidList, bidListResult);
    }

    @Test
    void getBidLists() {
        when(bidListR.findAll()).thenReturn(Collections.singletonList(bidList));
        List<BidList> bidListList = bidListS.getBidLists();
        assertEquals(Collections.singletonList(bidList), bidListList);
    }

    @Test
    void deleteBidList() {
        bidListS.deleteBidList(isA(Integer.class));
        verify(bidListR, times(1)).delete(bidList);
    }
}