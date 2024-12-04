package com.example;

public class InterestCalculator {

    /**
     * Calculates the interest based on principal, rate, and time.
     *
     * @param principal The principal amount.
     * @param rate      The interest rate (as a fraction, e.g., 0.05 for 5%).
     * @param time      The time period (in years).
     * @return The calculated interest.
     * @throws IllegalArgumentException if time is negative.
     */
    public double calculateInterest(double principal, double rate, double time) {
        if (time < 0) {
            throw new IllegalArgumentException("Time period cannot be negative");
        }
        return principal * rate * time;
    }
}
