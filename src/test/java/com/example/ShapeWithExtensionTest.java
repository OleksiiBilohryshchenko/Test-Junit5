package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ShapeExtension.class)
public class ShapeWithExtensionTest {

    @Test
    void testCircleName() {
        Shape shape = new Shape("Circle") {
            @Override
            public double calculateArea() {
                return 0;
            }
        };
        assertEquals("Circle", shape.getName());
    }

    @Test
    void testSquareName() {
        Shape shape = new Shape("Square") {
            @Override
            public double calculateArea() {
                return 0;
            }
        };
        assertEquals("Square", shape.getName());
    }
}
