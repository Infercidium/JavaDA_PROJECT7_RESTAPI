package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;

import java.util.List;

public interface TradeI {
    //Service
    /**
     * Add / Update a trade in the database.
     * @param trade : to add / update.
     */
    void postTrade(Trade trade);

    /**
     * Find the trade which has the given id.
     * @param id : to find.
     * @return the trade.
     */
    Trade getTrade(int id);

    /**
     * Find all trades.
     * @return the list of trades.
     */
    List<Trade> getTrades();

    /**
     * Delete the trade with the given id.
     * @param id : to delete.
     */
    void deleteTrade(int id);
}
