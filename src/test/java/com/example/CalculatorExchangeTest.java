package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorExchangeTest {

    @Mock
    private ExchangeService exchangeService;

    @InjectMocks
    private CalculatorExchange calculatorExchange;

    @Test
    void testAdd() {
        assertEquals(4, calculatorExchange.add(2, 2));
    }

    @Test
    void testConvertCurrency() {
        // Mock the exchange rate
        when(exchangeService.getExchangeRate("USD", "EUR")).thenReturn(0.85);

        // Call the convertCurrency method
        double result = calculatorExchange.convertCurrency("USD", "EUR", 100);

        // Assert the result
        assertEquals(85, result, 0.01);
    }
}
