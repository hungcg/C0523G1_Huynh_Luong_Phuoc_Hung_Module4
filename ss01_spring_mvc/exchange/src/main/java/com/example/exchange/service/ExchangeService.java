package com.example.exchange.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    public static double exchange(double usd) {
        if (String.valueOf(usd).equals("")) {
            return 0;
        } else {
            return usd * 24000;
        }
    }
}
