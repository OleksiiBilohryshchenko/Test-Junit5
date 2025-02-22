package com.example.dto;

import java.util.Collections;
import java.util.List;

public final class UserDTO {  // ✅ Class is final

    private final String username;  // ✅ Fields are final
    private final int age;
    private final List<String> roles; 

    public UserDTO(String username, int age, List<String> roles) {
        this.username = username;
        this.age = age;
        this.roles = Collections.unmodifiableList(roles); // ✅ Ensure immutability
    }

    public String getUsername() { return username; }
    public int getAge() { return age; }
    public List<String> getRoles() { return roles; } 

    // ❌ No setters
}
