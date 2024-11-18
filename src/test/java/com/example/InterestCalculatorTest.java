package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
