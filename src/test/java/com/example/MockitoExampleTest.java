package com.example;

import static org.mockito.Mockito.*; // Import Mockito methods
import org.junit.jupiter.api.Test;
import java.util.List;

public class MockitoExampleTest {

    @Test
    public void testMockitoMock() {
        // Create a mock object of List
        List<String> mockedList = mock(List.class);

        // Interact with the mock
        mockedList.add("one");
        mockedList.clear();

        // Verify interactions
        verify(mockedList).add("one"); // Verify add method was called with "one"
        verify(mockedList).clear();    // Verify clear method was called
    }
}
