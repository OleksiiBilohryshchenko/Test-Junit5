package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartTest {

    private Cart cart;
    private List<String> mockList;

    @BeforeEach
    public void setUp() {
        // Create a new Cart instance for each test
        cart = new Cart();
    }

    @Test
    public void testAddItem() {
        cart.addItem("Item0");
        cart.addItem("Item1");

        assertEquals(2, cart.getItems().size(), "Cart should have 2 items");
        assertEquals("Item0", cart.getItems().get(0), "First item should be 'Item0'");
        assertEquals("Item1", cart.getItems().get(1), "Second item should be 'Item1'");
    }

    @Test
    public void testRemoveItem_ValidIndex() {
        cart.addItem("Item0");
        cart.addItem("Item1");

        String removedItem = cart.removeItem(1);

        assertEquals("Item1", removedItem, "The removed item should be 'Item1'");
        assertEquals(1, cart.getItems().size(), "Cart should have 1 item after removal");
        assertEquals("Item0", cart.getItems().get(0), "The remaining item should be 'Item0'");
    }

    @Test
    public void testRemoveItem_InvalidIndex() {
        cart.addItem("Item0");
        cart.addItem("Item1");

        String removedItem = cart.removeItem(5); // Index out of bounds

        assertNull(removedItem, "Removing an invalid index should return null");
        assertEquals(2, cart.getItems().size(), "Cart should still have 2 items");
    }

    @Test
    public void testRemoveItem_WithMockedList() {
        // Step 1: Mock the List
        mockList = Mockito.mock(List.class);
        cart.setItems(mockList);

        // Step 2: Stub size() and remove() methods
        when(mockList.size()).thenReturn(2); // Mocked size
        when(mockList.remove(anyInt())).thenAnswer(invocation -> {
            int index = invocation.getArgument(0);
            return "MockedItem" + index;
        });

        // Step 3: Test removing an item at a valid index
        String removedItem = cart.removeItem(0);

        // Step 4: Assertions for valid index
        assertEquals("MockedItem0", removedItem, "The removed item should be 'MockedItem0'");
        verify(mockList, times(1)).remove(0); // Ensure remove(0) was called once

        // Step 5: Test removing an item at an invalid index
        String invalidRemovedItem = cart.removeItem(5); // Out of bounds
        assertNull(invalidRemovedItem, "Removing an invalid index should return null");
        verify(mockList, never()).remove(5); // Ensure remove was never called with invalid index
    }

}
