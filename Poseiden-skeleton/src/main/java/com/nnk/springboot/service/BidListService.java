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

    private static final Logger LOGGER
            = LoggerFactory.getLogger(BidListService.class);

    @Autowired
    private BidListRepository bidListR;

    //Service
    @Override
    public void postBidList(final BidList bidList) {
        bidListR.save(bidList);
        LOGGER.debug("BidList save");
    }

    @Override
    public BidList getBidList(final int id) {
        LOGGER.debug("BidList found");
        return bidListR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid bidList Id:" + id));
    }

    @Override
    public List<BidList> getBidLists() {
        LOGGER.debug("BidLists found");
        return bidListR.findAll();
    }

    @Override
    public void deleteBidList(final int id) {
        BidList bidList = getBidList(id);
        bidListR.delete(bidList);
        LOGGER.debug("BidList remove");
    }
}
