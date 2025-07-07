package org.example.userservice.model;

public class User {
    private Long id;
    private String email;
    private String name;

    // Constructor, Getters, Setters
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
