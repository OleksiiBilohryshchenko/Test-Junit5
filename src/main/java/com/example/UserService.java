package com.example;

import com.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser(String id) {
        return userRepository.findUserById(id);
    }

    public String addUser(String id, String name) {
        return userRepository.saveUser(id, name);
    }
}
