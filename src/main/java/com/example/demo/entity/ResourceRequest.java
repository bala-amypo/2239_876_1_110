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

    @NotBlank(message = "Resource type is required")
    @Column(nullable = false)
    private String resourceType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User requestedBy;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @NotBlank(message = "Purpose is required")
    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String status = "PENDING"; // default

    @PrePersist
    public void validateAndSetDefaults() {

        // Rule: status defaults to PENDING
        if (this.status == null) {
            this.status = "PENDING";
        }

        // Rule: startTime < endTime
        if (startTime != null && endTime != null && !startTime.isBefore(endTime)) {
            throw new RuntimeException("startTime must be before endTime");
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
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
}
