package com.example;

public interface AuthorizationService {
    void authorize(String username) throws ServiceUnavailableException;
}
