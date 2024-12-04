package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

public class MockitoAnnotationExample {

    @Mock
    List<String> mockedList;

    @BeforeEach
    public void setup() {
        // Initialize the mock objects annotated with @Mock
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUsingMockAnnotation() {
        // Use the mock
        mockedList.add("one");
        mockedList.clear();

        // Verify the behavior
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
