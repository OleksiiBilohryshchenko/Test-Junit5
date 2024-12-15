package com.example;

import java.util.List;

public class OrderProcessor {
    public void processOrders(List<OrderItem> items) {
        items.add(new OrderItem("Processing Fee", 5.0));
    }
}
