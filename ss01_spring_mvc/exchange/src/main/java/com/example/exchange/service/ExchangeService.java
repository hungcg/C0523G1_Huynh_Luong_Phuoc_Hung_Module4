package com.example.exchange.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService implements IExchangeService {
    public double exchange(double usd) {
        return usd * 24000;
    }
}
