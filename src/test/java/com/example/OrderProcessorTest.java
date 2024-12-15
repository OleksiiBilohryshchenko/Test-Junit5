package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

public class OrderProcessorTest {

    @Test
    void testProcessOrdersAddsProcessingFee() {
        // Step 1: Create a spy of OrderProcessor
        OrderProcessor orderProcessor = spy(new OrderProcessor());

        // Step 2: Create a test list of OrderItem objects
        List<OrderItem> testItems = new ArrayList<>();
        testItems.add(new OrderItem("Item1", 10.0));
        testItems.add(new OrderItem("Item2", 15.0));

        // Step 3: Use ArgumentCaptor to capture the argument
        ArgumentCaptor<List<OrderItem>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        // Step 4: Call the processOrders method
        orderProcessor.processOrders(testItems);

        // Step 5: Capture the argument passed to processOrders
        Mockito.verify(orderProcessor).processOrders(argumentCaptor.capture());

        // Get the captured list
        List<OrderItem> capturedItems = argumentCaptor.getValue();

        // Step 6: Assert that the captured list contains the "Processing Fee" item
        assertEquals(3, capturedItems.size(), "The list should contain one additional item.");
        boolean containsProcessingFee = capturedItems.stream()
                .anyMatch(item -> "Processing Fee".equals(item.getItemName()) && item.getPrice() == 5.0);
        assertTrue(containsProcessingFee, "The list should contain the 'Processing Fee' item.");
    }
}
