package com.example;

public class InterestCalculator {

    /**
     * Method to calculate interest.
     * @param principal Principal amount
     * @param rate Rate of interest (as a decimal, e.g., 5% = 0.05)
     * @param time Time period in years
     * @return Calculated interest
     */
    public double calculateInterest(double principal, double rate, double time) {
        return principal * rate * time;
    }
}
