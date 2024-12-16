package com.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeWithExtensionTest {

    @TestFactory
    List<DynamicTest> dynamicTestsForShapeNames() {
        return List.of(
                DynamicTest.dynamicTest("Test Circle name", () -> {
                    System.out.println("Before Test: Circle");
                    Shape shape = new Shape("Circle") {
                        @Override
                        public double calculateArea() {
                            return 0;
                        }
                    };
                    assertEquals("Circle", shape.getName());
                    System.out.println("After Test: Circle");
                }),
                DynamicTest.dynamicTest("Test Square name", () -> {
                    System.out.println("Before Test: Square");
                    Shape shape = new Shape("Square") {
                        @Override
                        public double calculateArea() {
                            return 0;
                        }
                    };
                    assertEquals("Square", shape.getName());
                    System.out.println("After Test: Square");
                })
        );
    }
}
