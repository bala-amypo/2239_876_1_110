package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resourceType;
    @ManyToOne
    private User requestedBy;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private String status = "PENDING";

    public ResourceRequest() {}

    public ResourceRequest(String resourceType, User requestedBy, LocalDateTime startTime,
                           LocalDateTime endTime, String purpose, String status) {
        this.resourceType = resourceType;
        this.requestedBy = requestedBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.purpose = purpose;
        this.status = status != null ? status : "PENDING";
    }

    // getters and setters
}
