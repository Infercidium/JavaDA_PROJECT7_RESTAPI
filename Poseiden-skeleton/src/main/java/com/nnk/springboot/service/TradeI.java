package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;

import java.util.List;

public interface TradeI {
    //Service
    void postTrade(Trade trade);

    Trade getTrade(int id);

    List<Trade> getTrades();

    void deleteTrade(int id);
}
