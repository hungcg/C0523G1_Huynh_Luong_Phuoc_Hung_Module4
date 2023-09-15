package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    double result;

    @Override
    public double calculator(double num1, double num2, String calculate) {
        switch (calculate) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;

        }
        return result;
    }
}
