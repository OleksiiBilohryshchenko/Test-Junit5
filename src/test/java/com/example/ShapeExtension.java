package com.example;

import org.junit.jupiter.api.extension.*;

public class ShapeExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println("Starting test: " + context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        Object testInstance = context.getTestInstance().orElseThrow();
        if (testInstance instanceof Shape shape) {
            assert shape.getName() != null && !shape.getName().trim().isEmpty() : "Shape name should not be null or empty";
        }
    }
}
