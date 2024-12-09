package com.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items = new ArrayList<>();

    // Add an item to the cart
    public void addItem(String item) {
        items.add(item);
    }

    // Remove an item from the cart at a specific index
    public String removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

    // Getter for items (for testing purposes)
    public List<String> getItems() {
        return items;
    }

    // Setter for items (added for testability)
    public void setItems(List<String> items) {
        this.items = items;
    }
}
