package com.example;

import org.junit.jupiter.api.extension.*;

public class ShapeExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println("Starting test: " + context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("Finished test: " + context.getDisplayName());
    }
}
