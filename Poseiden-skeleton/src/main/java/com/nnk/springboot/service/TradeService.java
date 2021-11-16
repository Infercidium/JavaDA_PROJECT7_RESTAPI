package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService implements TradeI {

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(TradeService.class);

    /**
     * Instantiation of tradeRepository.
     */
    @Autowired
    private TradeRepository tradeR;

    //Service

    /**
     * Add / Update a trade in the database.
     * @param trade : to add / update.
     */
    @Override
    public void postTrade(final Trade trade) {
        tradeR.save(trade);
        LOGGER.debug("Trade save");
    }

    /**
     * Find the trade which has the given id.
     * @param id : to find.
     * @return the trade.
     */
    @Override
    public Trade getTrade(final int id) {
        LOGGER.debug("Trade found");
        return tradeR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid trade Id:" + id));
    }

    /**
     * Find all trades.
     * @return the list of trades.
     */
    @Override
    public List<Trade> getTrades() {
        LOGGER.debug("Trades found");
        return tradeR.findAll();
    }

    /**
     * Delete the trade with the given id.
     * @param id : to delete.
     */
    @Override
    public void deleteTrade(final int id) {
        Trade trade = getTrade(id);
        tradeR.delete(trade);
        LOGGER.debug("Trade remove");
    }
}
