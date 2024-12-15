package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    void testSendAlertWithValidMessage() {
        // Step 1: Create a mock AlertGateway
        AlertGateway gatewayMock = mock(AlertGateway.class);

        // Step 2: Instantiate NotificationService with the mock gateway
        NotificationService service = new NotificationService(gatewayMock);

        // Step 3: Define a valid message
        String validMessage = "System is down!";

        // Step 4: Call the sendAlert method
        service.sendAlert(validMessage);

        // Step 5: Verify that gateway.send() is called with the correct message
        verify(gatewayMock).send(validMessage);
    }

    @Test
    void testSendAlertWithNullMessage() {
        // Step 1: Create a mock AlertGateway
        AlertGateway gatewayMock = mock(AlertGateway.class);

        // Step 2: Instantiate NotificationService with the mock gateway
        NotificationService service = new NotificationService(gatewayMock);

        // Step 3: Define a null message
        String nullMessage = null;

        // Step 4: Assert that InvalidAlertException is thrown
        assertThrows(InvalidAlertException.class, () -> service.sendAlert(nullMessage));

        // Step 5: Verify that gateway.send() is never called
        verifyNoInteractions(gatewayMock);
    }

    @Test
    void testSendAlertWithEmptyMessage() {
        // Step 1: Create a mock AlertGateway
        AlertGateway gatewayMock = mock(AlertGateway.class);

        // Step 2: Instantiate NotificationService with the mock gateway
        NotificationService service = new NotificationService(gatewayMock);

        // Step 3: Define an empty message
        String emptyMessage = "   ";

        // Step 4: Assert that InvalidAlertException is thrown
        assertThrows(InvalidAlertException.class, () -> service.sendAlert(emptyMessage));

        // Step 5: Verify that gateway.send() is never called
        verifyNoInteractions(gatewayMock);
    }
}
