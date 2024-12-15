package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShapeTest {

    @Test
    void testCalculateAreaWithMock() {
        // Create a mock of the Shape class
        Shape mockShape = mock(Shape.class);

        // Stub the calculateArea() method
        when(mockShape.calculateArea()).thenReturn(50.0);

        // Assert that the stubbed method returns the expected value
        assertEquals(50.0, mockShape.calculateArea());
        verify(mockShape).calculateArea();
    }

    @Test
    void testGetNameWithAnonymousSubclass() {
        // Anonymous subclass of Shape
        Shape anonymousShape = new Shape("Rectangle") {
            @Override
            public double calculateArea() {
                return 20.0;
            }
        };

        assertEquals("Rectangle", anonymousShape.getName());
    }
}
