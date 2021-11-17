package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidListService implements BidListI {

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(BidListService.class);

    /**
     * Instantiation of bidListRepository.
     */
    @Autowired
    private BidListRepository bidListR;

    //Service

    /**
     * Add a bidList in the database.
     * @param bidList : to add.
     */
    @Override
    public void postBidList(final BidList bidList) {
        bidListR.save(bidList);
        LOGGER.debug("BidList save");
    }

    /**
     * Update a bidList in the database.
     * @param bidList : to update.
     * @param id : to find origin bidList.
     */
    @Override
    public void updateBidList(final BidList bidList, final Integer id) {
        BidList originBid = getBidList(id);
        originBid.setAccount(bidList.getAccount());
        originBid.setType(bidList.getType());
        originBid.setBidQuantity(bidList.getBidQuantity());
        bidListR.save(originBid);
        LOGGER.debug("BidList update");
    }

    /**
     * Find the bidList which has the given id.
     * @param id : to find.
     * @return the bidList.
     */
    @Override
    public BidList getBidList(final int id) {
        LOGGER.debug("BidList found");
        return bidListR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid bidList Id:" + id));
    }

    /**
     * Find all bidLists.
     * @return the list of bidLists.
     */
    @Override
    public List<BidList> getBidLists() {
        LOGGER.debug("BidLists found");
        return bidListR.findAll();
    }

    /**
     * Removes the bidList which has the given id.
     * @param id : to delete.
     */
    @Override
    public void deleteBidList(final int id) {
        BidList bidList = getBidList(id);
        bidListR.delete(bidList);
        LOGGER.debug("BidList remove");
    }
}
