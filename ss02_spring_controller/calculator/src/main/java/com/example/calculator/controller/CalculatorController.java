package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @PostMapping("/calculator")
    public String calculate(@RequestParam double num1,
                            @RequestParam double num2,
                            @RequestParam String calculate, Model model) {
        double result = calculatorService.calculator(num1, num2, calculate);
        model.addAttribute("result",result);
        return "display";
    }
}
