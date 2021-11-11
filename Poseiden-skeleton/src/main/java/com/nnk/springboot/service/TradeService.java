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

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeService.class);

    @Autowired
    private TradeRepository tradeR;

    //Service
    @Override
    public void postTrade(final Trade trade) {
        tradeR.save(trade);
        LOGGER.debug("Trade save");
    }

    @Override
    public Trade getTrade(final int id) {
        LOGGER.debug("Trade found");
        return tradeR.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
    }

    @Override
    public List<Trade> getTrades() {
        LOGGER.debug("Trades found");
        return tradeR.findAll();
    }

    @Override
    public void deleteTrade(final int id) {
        Trade trade = getTrade(id);
        tradeR.delete(trade);
        LOGGER.debug("Trade remove");
    }
}
