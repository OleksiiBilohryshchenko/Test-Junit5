package com.repository;

public interface UserRepository {
    String findUserById(String id);

    String saveUser(String id, String name);
}
