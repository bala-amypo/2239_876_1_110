package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Table(name = "users")
public class User {
}

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String role;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "requestedBy")
    private List<ResourceRequest> requests;

    public User() {}

    public User(String fullName, String email, String role) {
        this.fullName = fullName;
        this.email = email;
        this.role = role != null ? role : "USER";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<ResourceRequest> getRequests() { return requests; }
    public void setRequests(List<ResourceRequest> requests) { this.requests = requests; }
}
