package com.example;

public class DiscountCalculator {

    public double calculateDiscount(Customer customer) {
        double discount = 0.0;

        if (customer.getYearsOfLoyalty() > 5) {
            discount = Math.max(discount, 0.05); // 5% loyalty discount
        }

        if (customer.getAge() > 65) {
            discount = Math.max(discount, 0.10); // 10% senior discount
        }

        if (customer.getPurchaseAmount() > 100) {
            discount = Math.max(discount, 0.15); // 15% large purchase discount
        }

        return discount;
    }
}
