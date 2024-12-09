package com.example;

import java.math.BigDecimal;

public class PaymentProcessor {
    private final BankService bankService;

    public PaymentProcessor(BankService bankService) {
        this.bankService = bankService;
    }

    public boolean processPayment(AccountDetails details, BigDecimal amount) {
        // Delegates payment processing to the BankService
        return bankService.performPayment(details, amount);
    }
}
