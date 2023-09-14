package com.example.exchange.controller;



import com.example.exchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/exchange")
    public String home(@RequestParam String usd, Model model) {
        if (usd.equals("")) {
            model.addAttribute("result", "please input again!");
        } else {
            double finalResult = exchangeService.exchange(Double.parseDouble(usd));
            model.addAttribute("result", finalResult);
        }
        return "/home";
    }
}
