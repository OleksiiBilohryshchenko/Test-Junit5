package com.example;

public class NotificationService {
    private AlertGateway gateway;

    public NotificationService(AlertGateway gateway) {
        this.gateway = gateway;
    }

    public void sendAlert(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new InvalidAlertException("Alert message is invalid");
        }
        gateway.send(message);
    }
}
