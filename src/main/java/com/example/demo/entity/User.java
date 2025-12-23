package com.example.demo.entity;

public class User {

    private Long id;
    private String email;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
