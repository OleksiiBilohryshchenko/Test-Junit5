package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Mock
    private InventoryManager inventoryManager;

    @Mock
    private PaymentGateway paymentGateway;

    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldProcessOrderSuccessfully() {
        // Given
        Item item = new Item("Laptop");
        Order order = new Order(item, 1000.00);
        given(inventoryManager.isInStock(item)).willReturn(true);
        given(paymentGateway.processPayment(order.getAmount())).willReturn(true);

        // When
        boolean result = orderService.processOrder(order);

        // Then
        then(inventoryManager).should().isInStock(item);
        then(paymentGateway).should().processPayment(order.getAmount());
        assertTrue(result, "Order should be processed successfully");
    }

    @Test
    void shouldFailToProcessOrderWhenOutOfStock() {
        // Given
        Item item = new Item("Smartphone");
        Order order = new Order(item, 500.00);
        given(inventoryManager.isInStock(item)).willReturn(false);

        // When & Then
        OutOfStockException exception = assertThrows(OutOfStockException.class, () -> {
            orderService.processOrder(order);
        });

        then(inventoryManager).should().isInStock(item);
        then(paymentGateway).shouldHaveNoInteractions();
        assertEquals("Item out of stock", exception.getMessage());
    }

    @Test
    void shouldFailToProcessOrderWhenPaymentDeclines() {
        // Given
        Item item = new Item("Headphones");
        Order order = new Order(item, 200.00);
        given(inventoryManager.isInStock(item)).willReturn(true);
        given(paymentGateway.processPayment(order.getAmount())).willReturn(false);

        // When
        boolean result = orderService.processOrder(order);

        // Then
        then(inventoryManager).should().isInStock(item);
        then(paymentGateway).should().processPayment(order.getAmount());
        assertFalse(result, "Order should fail due to payment decline");
    }
}
