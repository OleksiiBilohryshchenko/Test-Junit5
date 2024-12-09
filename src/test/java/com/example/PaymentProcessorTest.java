package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PaymentProcessorTest {

    @Test
    public void testProcessPaymentSuccess() {
        // Step 1: Create a spy of BankService
        BankService bankServiceSpy = Mockito.spy(new BankService());

        // Step 2: Stub the performPayment method to simulate a successful payment
        AccountDetails details = new AccountDetails("12345", "John Doe");
        BigDecimal amount = BigDecimal.valueOf(100.00);

        doReturn(true).when(bankServiceSpy).performPayment(details, amount);

        // Step 3: Create an instance of PaymentProcessor with the spied BankService
        PaymentProcessor paymentProcessor = new PaymentProcessor(bankServiceSpy);

        // Step 4: Call processPayment and capture the result
        boolean result = paymentProcessor.processPayment(details, amount);

        // Step 5: Verify the method behavior
        verify(bankServiceSpy, times(1)).performPayment(details, amount);
        assertTrue(result, "Payment should be processed successfully");
    }
}
