package com.example;

public class CalculatorClient {
    private final CalculatorService calculatorService;

    public CalculatorClient(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double performAddition(double a, double b) {
        return calculatorService.add(a, b);
    }

    public double performSubtraction(double a, double b) {
        return calculatorService.subtract(a, b);
    }

    public double performMultiplication(double a, double b) {
        return calculatorService.multiply(a, b);
    }

    public double performDivision(double a, double b) {
        return calculatorService.divide(a, b);
    }
}
