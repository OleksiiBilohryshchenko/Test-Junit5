package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class InterestCalculatorTest {

    /**
     * Method to supply test data for parameterized test.
     * @return Stream of arguments containing principal, rate, time, and expected interest.
     */
    static Stream<Arguments> interestParameters() {
        return Stream.of(
                Arguments.of(1000.00, 0.05, 1, 50.00),   // Principal: 1000, Rate: 5%, Time: 1 year, Expected: 50
                Arguments.of(2000.00, 0.03, 2, 120.00), // Principal: 2000, Rate: 3%, Time: 2 years, Expected: 120
                Arguments.of(1500.00, 0.04, 3, 180.00), // Principal: 1500, Rate: 4%, Time: 3 years, Expected: 180
                Arguments.of(500.00, 0.06, 0.5, 15.00)  // Principal: 500, Rate: 6%, Time: 6 months, Expected: 15
        );
    }

    @DisplayName("Test calculateInterest method with multiple scenarios")
    @ParameterizedTest(name = "Principal: {0}, Rate: {1}, Time: {2}, Expected: {3}")
    @MethodSource("interestParameters")
    public void testCalculateInterest(double principal, double rate, double time, double expected) {
        // Arrange
        InterestCalculator calculator = new InterestCalculator();

        // Act
        double actual = calculator.calculateInterest(principal, rate, time);

        // Assert
        assertEquals(expected, actual, 0.001, "Interest calculation failed");
    }

    @Test
    @DisplayName("Test simple interest calculation")
    public void testCalculateSimpleInterest() {
        // Arrange
        double principal = 1000.0;
        double rate = 0.05; // 5%
        int time = 2; // 2 years
        InterestCalculator calculator = new InterestCalculator();

        // Act
        double actual = calculator.calculateInterest(principal, rate, time);

        // Assert
        double expected = 100.0; // Principal * Rate * Time
        assertEquals(expected, actual, 0.001, "Simple interest calculation failed");
    }

    @Test
    @DisplayName("Test interest calculation with zero rate")
    public void testZeroInterestRate() {
        // Arrange
        double principal = 1000.0;
        double rate = 0.0; // 0%
        int time = 2; // 2 years
        InterestCalculator calculator = new InterestCalculator();

        // Act
        double actual = calculator.calculateInterest(principal, rate, time);

        // Assert
        double expected = 0.0;
        assertEquals(expected, actual, 0.001, "Zero interest rate should return zero interest");
    }

    @Test
    @DisplayName("Test interest calculation with negative time period")
    public void testNegativeTimePeriod() {
        // Arrange
        double principal = 1000.0;
        double rate = 0.05; // 5%
        int time = -1; // Negative time
        InterestCalculator calculator = new InterestCalculator();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateInterest(principal, rate, time);
        }, "Negative time period should throw an exception");
    }

    @Test
    @DisplayName("Test large input values")
    public void testLargePrincipalAndRate() {
        // Arrange
        double principal = 1_000_000.0; // Large principal
        double rate = 0.1; // 10%
        int time = 5; // 5 years
        InterestCalculator calculator = new InterestCalculator();

        // Act
        double actual = calculator.calculateInterest(principal, rate, time);

        // Assert
        double expected = 500_000.0; // Principal * Rate * Time
        assertEquals(expected, actual, 0.001, "Large input values failed");
    }

    @Test
    @DisplayName("Test interest calculation with negative principal")
    public void testNegativePrincipal() {
        double principal = -1000.0;
        double rate = 0.05; // 5%
        int time = 1; // 1 year
        InterestCalculator calculator = new InterestCalculator();

        double expected = -50.0; // Negative principal results in negative interest
        double actual = calculator.calculateInterest(principal, rate, time);

        assertEquals(expected, actual, 0.001, "Negative principal calculation failed");
    }

    @Test
    @DisplayName("Test interest calculation with zero principal")
    public void testZeroPrincipal() {
        double principal = 0.0;
        double rate = 0.05; // 5%
        int time = 1; // 1 year
        InterestCalculator calculator = new InterestCalculator();

        double actual = calculator.calculateInterest(principal, rate, time);

        assertEquals(0.0, actual, "Interest calculation with zero principal failed");
    }


}
