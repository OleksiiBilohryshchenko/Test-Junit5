package com.example;

public class Customer {

    private int yearsOfLoyalty;
    private int age;
    private double purchaseAmount;

    public Customer(int yearsOfLoyalty, int age, double purchaseAmount) {
        this.yearsOfLoyalty = yearsOfLoyalty;
        this.age = age;
        this.purchaseAmount = purchaseAmount;
    }

    public int getYearsOfLoyalty() {
        return yearsOfLoyalty;
    }

    public int getAge() {
        return age;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }
}
