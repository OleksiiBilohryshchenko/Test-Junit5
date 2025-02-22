package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorTest {

    @Test
    public void testNoDiscount() {
        Customer customer = new Customer(0, 30, 50);
        DiscountCalculator calc = new DiscountCalculator();
        assertEquals(0.0, calc.calculateDiscount(customer), 0.001);
    }

    @Test
    public void testLoyaltyDiscount() {
        Customer customer = new Customer(6, 30, 50);
        DiscountCalculator calc = new DiscountCalculator();
        assertEquals(0.05, calc.calculateDiscount(customer), 0.001);
    }

    @Test
    public void testSeniorDiscount() {
        Customer customer = new Customer(0, 70, 50);
        DiscountCalculator calc = new DiscountCalculator();
        assertEquals(0.10, calc.calculateDiscount(customer), 0.001);
    }

    @Test
    public void testLargePurchaseDiscount() {
        Customer customer = new Customer(0, 30, 150);
        DiscountCalculator calc = new DiscountCalculator();
        assertEquals(0.15, calc.calculateDiscount(customer), 0.001);
    }

    @Test
    public void testMultipleDiscounts() {
        Customer customer = new Customer(10, 70, 200);
        DiscountCalculator calc = new DiscountCalculator();
        // Multiple conditions are met; expect the highest discount (15%)
        assertEquals(0.15, calc.calculateDiscount(customer), 0.001);
    }

    // Below are boundary tests to ensure we cover edge cases

    @Test
    public void testLoyaltyBoundary() {
        // Exactly 5 years should NOT trigger a loyalty discount.
        Customer customer = new Customer(5, 30, 50);
        DiscountCalculator calc = new DiscountCalculator();
        assertEquals(0.0, calc.calculateDiscount(customer), 0.001);
    }

    @Test
    public void testSeniorBoundary() {
        // Exactly 65 years should NOT trigger a senior discount.
        Customer customer = new Customer(0, 65, 50);
        DiscountCalculator calc = new DiscountCalculator();
        assertEquals(0.0, calc.calculateDiscount(customer), 0.001);
    }

    @Test
    public void testPurchaseAmountBoundary() {
        // Exactly 100 should NOT trigger a large purchase discount.
        Customer customer = new Customer(0, 30, 100);
        DiscountCalculator calc = new DiscountCalculator();
        assertEquals(0.0, calc.calculateDiscount(customer), 0.001);
    }
}