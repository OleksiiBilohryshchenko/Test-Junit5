package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    @Test
    public void testWithdrawThrowsExceptionForInsufficientFunds() {
        // Arrange
        BankAccount bankAccount = new BankAccount(100.0); // Initial balance: $100

        // Act & Assert
        InsufficientFundsException exception = assertThrows(
            InsufficientFundsException.class,
            () -> bankAccount.withdraw(150.0) // Attempt to withdraw $150
        );

        // Verify the exception message
        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }

    @Test
    public void testWithdrawReducesBalanceForSufficientFunds() throws InsufficientFundsException {
        // Arrange
        BankAccount bankAccount = new BankAccount(100.0); // Initial balance: $100

        // Act
        bankAccount.withdraw(50.0); // Withdraw $50

        // Assert
        assertEquals(50.0, bankAccount.getBalance());
    }
}
