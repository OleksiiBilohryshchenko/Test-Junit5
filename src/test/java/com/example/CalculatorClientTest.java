package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorClientTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorClient calculatorClient;

    @BeforeEach
    void setup() {
        // Initialize the mock object before each test
        Mockito.reset(calculatorService);
    }

    @Test
    void testPerformAddition() {
        // Arrange: Mock the behavior of add() method
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);

        // Act: Call the performAddition() method
        double result = calculatorClient.performAddition(10.0, 20.0);

        // Assert: Verify the result
        assertEquals(30.0, result);

        // Verify that the add() method was called with the correct arguments
        verify(calculatorService).add(10.0, 20.0);
    }

    @Test
    void testPerformSubtractionWithMatchers() {
        // Arrange: Use argument matchers to generalize inputs
        when(calculatorService.subtract(anyDouble(), anyDouble())).thenReturn(5.0);

        // Act: Call the performSubtraction() method
        double result = calculatorClient.performSubtraction(15.0, 10.0);

        // Assert: Verify the result
        assertEquals(5.0, result);

        // Verify that the subtract() method was called
        verify(calculatorService).subtract(anyDouble(), anyDouble());
    }

    @Test
    void testResetMock() {
        // Arrange: Set behavior before resetting
        when(calculatorService.add(5.0, 5.0)).thenReturn(10.0);

        // Act: Call the method and verify it works
        double result = calculatorClient.performAddition(5.0, 5.0);
        assertEquals(10.0, result);

        // Reset the mock
        reset(calculatorService);

        // Arrange after reset: Change behavior
        when(calculatorService.add(5.0, 5.0)).thenReturn(20.0);

        // Act: Call the method after reset
        result = calculatorClient.performAddition(5.0, 5.0);

        // Assert: Verify the new behavior
        assertEquals(20.0, result);
    }
}
