package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // Added for authentication

    private String role;

    private LocalDateTime createdAt;

    // One user can make many resource requests
    @OneToMany(mappedBy = "requestedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResourceRequest> resourceRequests;

    // No-arg constructor
    public User() {
        this.createdAt = LocalDateTime.now();
        this.role = "USER"; // default role
    }

    // Parameterized constructor
    public User(String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = (role == null || role.isEmpty()) ? "USER" : role;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = (role == null || role.isEmpty()) ? "USER" : role; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public List<ResourceRequest> getResourceRequests() { return resourceRequests; }
    public void setResourceRequests(List<ResourceRequest> resourceRequests) { this.resourceRequests = resourceRequests; }
}
