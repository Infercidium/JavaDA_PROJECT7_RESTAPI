package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;

import java.util.List;

public interface BidListI {
    //Service
    /**
     * Add / Update a bidList in the database.
     * @param bidList : to add / update.
     */
    void postBidList(BidList bidList);

    /**
     * Find the bidList which has the given id.
     * @param id : to find.
     * @return the bidList.
     */
    BidList getBidList(int id);

    /**
     * Find all bidLists.
     * @return the list of bidLists.
     */
    List<BidList> getBidLists();

    /**
     * Removes the bidList which has the given id.
     * @param id : to delete.
     */
    void deleteBidList(int id);
}
