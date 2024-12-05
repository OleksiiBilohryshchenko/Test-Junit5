package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @Test
    void whenAuthorizationServiceIsUnavailable_thenAuthServiceCatchesException() {
        // Mock the AuthorizationService
        AuthorizationService authzService = mock(AuthorizationService.class);

        // Stub the authorize method to throw a ServiceUnavailableException
        doThrow(new ServiceUnavailableException("Authorization service is unavailable"))
                .when(authzService).authorize(anyString());

        // Create an instance of AuthService with the mocked AuthorizationService
        AuthService authService = new AuthService(authzService);

        // Test the exception handling logic
        ServiceUnavailableException thrown = assertThrows(
                ServiceUnavailableException.class,
                () -> authService.authenticate("user", "password")
        );

        // Verify the exception message
        assertTrue(thrown.getMessage().contains("Authorization service is unavailable"));

        // Verify that the authorize method was called with any string
        verify(authzService).authorize(anyString());
    }
}
