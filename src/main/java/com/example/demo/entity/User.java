package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private Integer age;

    // REQUIRED by JPA & tests
    public User() {
    }

    // REQUIRED by tests
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // REQUIRED by tests
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // REQUIRED by tests
    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters & Setters (ALL)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
