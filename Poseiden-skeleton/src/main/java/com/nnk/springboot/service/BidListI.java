package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;

import java.util.List;

public interface BidListI {
    //Service
    void postBidList(BidList bidList);

    BidList getBidList(int id);

    List<BidList> getBidLists();

    void deleteBidList(int id);
}
