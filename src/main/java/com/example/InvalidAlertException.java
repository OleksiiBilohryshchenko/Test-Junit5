package com.example;

public class InvalidAlertException extends RuntimeException {
    public InvalidAlertException(String message) {
        super(message);
    }
}
