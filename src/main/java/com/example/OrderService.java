package com.example;

public class OrderService {
    private InventoryManager inventoryManager;
    private PaymentGateway paymentGateway;

    public OrderService(InventoryManager inventoryManager, PaymentGateway paymentGateway) {
        this.inventoryManager = inventoryManager;
        this.paymentGateway = paymentGateway;
    }

    public boolean processOrder(Order order) {
        if (inventoryManager.isInStock(order.getItem())) {
            return paymentGateway.processPayment(order.getAmount());
        } else {
            throw new OutOfStockException("Item out of stock");
        }
    }
}
