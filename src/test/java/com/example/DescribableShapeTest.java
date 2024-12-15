package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescribableShapeTest {

    @Test
    void testDescribe() {
        Describable describable = () -> "A generic shape description";
        assertEquals("A generic shape description", describable.describe());
    }
}
