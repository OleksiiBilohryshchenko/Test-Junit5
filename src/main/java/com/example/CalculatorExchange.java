package com.example;

public class CalculatorExchange {
    private final ExchangeService exchangeService;

    public CalculatorExchange(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        double exchangeRate = exchangeService.getExchangeRate(fromCurrency, toCurrency);
        return amount * exchangeRate;
    }
}
