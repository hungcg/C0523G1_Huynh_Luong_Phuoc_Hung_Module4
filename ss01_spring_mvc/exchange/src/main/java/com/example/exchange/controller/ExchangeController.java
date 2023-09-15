package com.example.exchange.controller;


import com.example.exchange.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {
    @Autowired
    private IExchangeService exchangeService;

    @GetMapping("")
    public String showFormExchange() {
        return "display";
    }

    @PostMapping("exchange")
    public String exchangeMoney(@RequestParam(name = "usd", required = false, defaultValue = "0")
                                              double usd, Model model) {
        double finalResult = exchangeService.exchange(usd);
        model.addAttribute("result", finalResult);
        return "display";
    }
}
