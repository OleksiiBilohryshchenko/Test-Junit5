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
        // Step 1: Add items to the cart
        cart.addItem("Item0");
        cart.addItem("Item1");

        // Step 2: Verify the size of the cart
        assertEquals(2, cart.getItems().size(), "Cart should have 2 items");

        // Step 3: Verify the contents of the cart
        assertEquals("Item0", cart.getItems().get(0), "First item should be 'Item0'");
        assertEquals("Item1", cart.getItems().get(1), "Second item should be 'Item1'");
    }

    @Test
    public void testRemoveItem_ValidIndex() {
        // Step 1: Populate the cart
        cart.addItem("Item0");
        cart.addItem("Item1");

        // Step 2: Remove an item at a valid index
        String removedItem = cart.removeItem(1);

        // Step 3: Verify the correct item is removed
        assertEquals("Item1", removedItem, "The removed item should be 'Item1'");

        // Step 4: Verify the size of the cart after removal
        assertEquals(1, cart.getItems().size(), "Cart should have 1 item after removal");

        // Step 5: Verify the remaining items in the cart
        assertEquals("Item0", cart.getItems().get(0), "The remaining item should be 'Item0'");
    }

    @Test
    public void testRemoveItem_InvalidIndex() {
        // Step 1: Populate the cart
        cart.addItem("Item0");
        cart.addItem("Item1");

        // Step 2: Attempt to remove an item at an invalid index
        String removedItem = cart.removeItem(5); // Index out of bounds

        // Step 3: Verify that null is returned
        assertNull(removedItem, "Removing an invalid index should return null");

        // Step 4: Verify the size of the cart remains unchanged
        assertEquals(2, cart.getItems().size(), "Cart should still have 2 items");
    }

    @Test
    public void testRemoveItem_ValidIndex_WithAddItem() {
        // Step 1: Add multiple items
        cart.addItem("Item0");
        cart.addItem("Item1");
        cart.addItem("Item2");

        // Step 2: Verify the initial size
        assertEquals(3, cart.getItems().size(), "Cart should have 3 items before removal");

        // Step 3: Remove an item
        String removedItem = cart.removeItem(1);

        // Step 4: Verify the correct item is removed
        assertEquals("Item1", removedItem, "The removed item should be 'Item1'");

        // Step 5: Verify the cart after removal
        assertEquals(2, cart.getItems().size(), "Cart should have 2 items after removal");
        assertEquals("Item0", cart.getItems().get(0), "First item should still be 'Item0'");
        assertEquals("Item2", cart.getItems().get(1), "Second item should now be 'Item2'");
    }

    @Test
    public void testRemoveItem_WithMockedList() {
        // Step 1: Mock the List
        mockList = Mockito.mock(List.class);

        // Step 2: Replace the internal list in Cart with the mock
        cart.setItems(mockList);

        // Step 3: Stub the size and remove methods
        when(mockList.size()).thenReturn(2);
        when(mockList.remove(anyInt())).thenAnswer(invocation -> {
            int index = invocation.getArgument(0);
            return "MockedItem" + index;
        });

        // Step 4: Remove an item using the mocked list
        String removedItem = cart.removeItem(0);

        // Step 5: Verify the mocked behavior
        assertEquals("MockedItem0", removedItem, "The removed item should be 'MockedItem0'");
        verify(mockList, times(1)).remove(0); // Ensure remove is called once
    }
}
