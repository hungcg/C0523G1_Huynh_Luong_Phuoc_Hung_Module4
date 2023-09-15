package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("calculator")
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    public String displayCalculator() {
        return "display";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double number1,
                            @RequestParam double number2,
                            @RequestParam String calculate, Model model) {
        double result = calculatorService.calculator(number1, number2, calculate);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        if (number2 != 0) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("error", "Cannot make this calculate with number 2 = zero");
        }
        return "display";
    }
}
