package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String resourceType;

    // Many requests can belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User requestedBy;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    @NotBlank(message = "Purpose is required")
    private String purpose;

    @Column(nullable = false)
    private String status;

    // One ResourceRequest can have one ResourceAllocation
    @OneToOne(mappedBy = "resourceRequest", cascade = CascadeType.ALL)
    private ResourceAllocation resourceAllocation;

    // No-arg constructor
    public ResourceRequest() {
    }

    // Parameterized constructor
    public ResourceRequest(String resourceType, User requestedBy, LocalDateTime startTime, LocalDateTime endTime, String purpose, String status) {
        this.resourceType = resourceType;
        this.requestedBy = requestedBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.purpose = purpose;
        this.status = status;
    }

    // Set default values before insert
    @PrePersist
    public void prePersist() {
        if (this.status == null || this.status.isEmpty()) {
            this.status = "PENDING";
        }
    }

    // Custom validation for start and end time
    @PrePersist
    @PreUpdate
    public void validateTime() {
        if (startTime != null && endTime != null && !startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("startTime must be before endTime");
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResourceAllocation getResourceAllocation() {
        return resourceAllocation;
    }

    public void setResourceAllocation(ResourceAllocation resourceAllocation) {
        this.resourceAllocation = resourceAllocation;
    }
}
