package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MockitoStaticTest {

    @Test
    void testStaticMethodWithMockito() {
        // Step 1: Use mockStatic() to mock the static method
        try (MockedStatic<UtilityClass> mockedStatic = mockStatic(UtilityClass.class)) {

            // Step 2: Stub the static method
            mockedStatic.when(UtilityClass::getStatus).thenReturn("Mocked Status");

            // Step 3: Call the static method and assert the result
            String result = UtilityClass.getStatus();
            assertEquals("Mocked Status", result);

            // Step 4: Verify that the static method was called exactly once
            mockedStatic.verify(UtilityClass::getStatus, times(1));
        }
    }
}
