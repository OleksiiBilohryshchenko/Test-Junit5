package com.example;

import com.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.listeners.InvocationListener;
import org.mockito.invocation.InvocationOnMock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest {

    private UserRepository userRepository;
    private UserService userService;
    private List<String> invocationDetails;

    @BeforeEach
    public void setUp() {
        // List to store invocation details
        invocationDetails = new ArrayList<>();

        // Custom invocation listener
        InvocationListener listener = invocation -> {
            System.out.println("Listener triggered.");
            if (invocation instanceof InvocationOnMock mockInvocation) {
                try {
                    // Retrieve method name
                    String methodName = mockInvocation.getMethod().getName();

                    // Retrieve method arguments
                    Object[] args = mockInvocation.getArguments();

                    // Log invocation details
                    invocationDetails.add("Method: " + methodName + ", Args: " + java.util.Arrays.toString(args));
                    System.out.println("Invocation recorded: " + methodName);
                } catch (Exception e) {
                    System.err.println("Error retrieving method details: " + e.getMessage());
                }
            }
        };

        // Create the mock with MockSettings
        MockSettings settings = Mockito.withSettings()
                .serializable() // Make the mock serializable
                .defaultAnswer(invocation -> {
                    String methodName = "Unknown";
                    if (invocation instanceof InvocationOnMock mockInvocation) {
                        methodName = mockInvocation.getMethod().getName();
                        Object[] args = mockInvocation.getArguments();
                        invocationDetails.add("Manual Entry -> Method: " + methodName + ", Args: " + java.util.Arrays.toString(args));
                    }

                    System.out.println("Unstubbed method called: " + methodName);
                    return "Default Answer";
                })
                .invocationListeners(listener);

        userRepository = Mockito.mock(UserRepository.class, settings);
        userService = new UserService(userRepository);

        System.out.println("MockSettings applied to userRepository");
    }

    @Test
    public void testStubbedMethod() {
        // Stub a method
        Mockito.when(userRepository.findUserById("123")).thenReturn("Alice");

        // Call the stubbed method
        String result = userService.getUser("123");

        // Verify the behavior
        assertEquals("Alice", result);
    }

    @Test
    public void testUnstubbedMethod() {
        // Call an unstubbed method
        String result = userService.addUser("456", "Bob");

        // Verify the default answer
        assertEquals("Default Answer", result);

        // Debugging: print the recorded invocations
        if (invocationDetails.isEmpty()) {
            System.out.println("Invocation details list is empty.");
        } else {
            invocationDetails.forEach(System.out::println);
        }

        // Verify invocation listener recorded the call
        assertEquals(1, invocationDetails.size(), "Invocation listener did not record the method call.");
    }
}
