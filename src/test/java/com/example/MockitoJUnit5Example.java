package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) // Integrate Mockito with JUnit 5
public class MockitoJUnit5Example {

    @Mock
    List<String> mockedList;

    @InjectMocks
    MyClass myClass; // Automatically inject the mocked dependencies into this class

    @Test
    public void testUsingExtendWith() {
        // Call the method on the class that uses the mocked list
        myClass.performOperation();

        // Verify the interaction with the mock
        verify(mockedList).add("one");
    }

    // A simple class that uses the List dependency
    public static class MyClass {
        List<String> list;

        public void performOperation() {
            list.add("one");
        }
    }
}
