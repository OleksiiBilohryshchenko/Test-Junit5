package com.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

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

    @TestFactory
    List<DynamicTest> dynamicTestsForShapeNames() {
        return List.of(
                DynamicTest.dynamicTest("Test Circle name", () -> {
                    Shape shape = new Shape("Circle") {
                        @Override public double calculateArea() { return 0; }
                    };
                    assertEquals("Circle", shape.getName());
                }),
                DynamicTest.dynamicTest("Test Square name", () -> {
                    Shape shape = new Shape("Square") {
                        @Override public double calculateArea() { return 0; }
                    };
                    assertEquals("Square", shape.getName());
                })
        );
    }
}
