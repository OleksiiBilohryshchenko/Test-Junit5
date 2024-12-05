package com.example;

public class AuthService {
    private final AuthorizationService authorizationService;

    public AuthService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    public void authenticate(String username, String password) throws ServiceUnavailableException {
        // Simulate an authentication process that relies on the authorization service
        authorizationService.authorize(username);
    }
}
