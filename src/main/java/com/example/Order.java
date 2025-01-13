package com.example;

public class Order {
    private Item item;
    private double amount;

    public Order(Item item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }
}
