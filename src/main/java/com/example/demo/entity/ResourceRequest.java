package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status = "PENDING";

    private LocalDateTime requestedAt;

    @PrePersist
    public void onCreate() {
        this.requestedAt = LocalDateTime.now();
    }

    // getters & setters
}
