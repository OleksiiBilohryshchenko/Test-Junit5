package com.example;

import org.junit.jupiter.api.*; // For JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*; // For assertions

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // This method runs before each test to initialize the Calculator instance
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        // This method runs after each test to clean up (optional in this case)
        calculator = null;
    }

    @Nested
    @DisplayName("Addition and Subtraction Tests")
    class AdditionSubtractionTests {

        @Test
        @DisplayName("Addition Test")
        public void testAddition() {
            double result = calculator.add(10.5, 20.5); // Testing addition
            assertEquals(31.0, result, "The addition result should be 31.0");
        }

        @Test
        @DisplayName("Subtraction Test")
        public void testSubtraction() {
            double result = calculator.subtract(30.0, 10.0); // Testing subtraction
            assertEquals(20.0, result, "The subtraction result should be 20.0");
        }
    }

    @Nested
    @DisplayName("Multiplication and Division Tests")
    class MultiplicationDivisionTests {

        @Test
        @DisplayName("Multiplication Test")
        public void testMultiplication() {
            double result = calculator.multiply(5.0, 4.0); // Testing multiplication
            assertEquals(20.0, result, "The multiplication result should be 20.0");
        }

        @Test
        @DisplayName("Division Test")
        public void testDivision() {
            double result = calculator.divide(20.0, 4.0); // Testing division
            assertEquals(5.0, result, "The division result should be 5.0");
        }

        @Test
        @Disabled("Temporarily disabling this test")
        @DisplayName("Disabled Division Test")
        public void testDisabledDivision() {
            double result = calculator.divide(15.0, 3.0); // Temporarily disabled test
            assertEquals(5.0, result, "The division result should be 5.0");
        }
    }

    @Test
    @DisplayName("Division by Zero Test")
    public void testDivisionByZero() {
        // Ensure the division method throws an ArithmeticException when dividing by zero
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10.0, 0.0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    @DisplayName("Test multiplication with zero")
    public void testMultiplicationWithZero() {
        assertEquals(0.0, calculator.multiply(0.0, 100.0), "Multiplication with zero failed");
    }

    @Test
    @DisplayName("Test division with negative numbers")
    public void testDivisionWithNegativeNumbers() {
        assertEquals(-5.0, calculator.divide(10.0, -2.0), "Division with negative numbers failed");
    }


}
