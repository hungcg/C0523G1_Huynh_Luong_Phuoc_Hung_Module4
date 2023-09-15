package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {


    @Override
    public double calculator(double number1, double number2, String calculate) {
        double result = 0;
        switch (calculate) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
        }
        return result;
    }
}
