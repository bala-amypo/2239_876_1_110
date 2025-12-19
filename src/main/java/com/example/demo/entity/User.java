package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    // 🔹 Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Fields
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String role;

    private LocalDateTime createdAt;

    // 🔹 One User → Many ResourceRequests
    @OneToMany(mappedBy = "requestedBy", cascade = CascadeType.ALL)
    private List<ResourceRequest> resourceRequests;

    // 🔹 No-arg constructor
    public User() {
        this.createdAt = LocalDateTime.now();
        this.role = "USER"; // default role
    }

    // 🔹 Parameterized constructor
    public User(String fullName, String email, String role) {
        this.fullName = fullName;
        this.email = email;
        this.role = (role == null || role.isEmpty()) ? "USER" : role;
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = (role == null || role.isEmpty()) ? "USER" : role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<ResourceRequest> getResourceRequests() {
        return resourceRequests;
    }

    public void setResourceRequests(List<ResourceRequest> resourceRequests) {
        this.resourceRequests = resourceRequests;
    }
}
