package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {

    // 🔹 Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Requested resource type
    private String resourceType;

    // 🔹 Many Requests → One User
    @ManyToOne
    @JoinColumn(name = "requested_by_id", nullable = false)
    private User requestedBy;

    // 🔹 Start time
    private LocalDateTime startTime;

    // 🔹 End time
    private LocalDateTime endTime;

    // 🔹 Purpose (Mandatory)
    @NotBlank(message = "Purpose is required")
    private String purpose;

    // 🔹 Status: PENDING / APPROVED / REJECTED
    private String status;

    // 🔹 One Request → One Allocation
    @OneToOne(mappedBy = "resourceRequest", cascade = CascadeType.ALL)
    private ResourceAllocation resourceAllocation;

    // 🔹 No-arg constructor
    public ResourceRequest() {
        this.status = "PENDING"; // default status
    }

    // 🔹 Parameterized constructor
    public ResourceRequest(
            String resourceType,
            User requestedBy,
            LocalDateTime startTime,
            LocalDateTime endTime,
            String purpose,
            String status) {

        this.resourceType = resourceType;
        this.requestedBy = requestedBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.purpose = purpose;
        this.status = (status == null || status.isEmpty()) ? "PENDING" : status;
    }

    // 🔹 Business rule: startTime < endTime
    @PrePersist
    @PreUpdate
    private void validateTime() {
        if (startTime != null && endTime != null && !startTime.isBefore(endTime)) {
            throw new RuntimeException("Start time must be before end time");
        }
    }

    // 🔹 Getters and Setters
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

    public ResourceAllocation getResourceAllocation() {
        return resourceAllocation;
    }

    public void setResourceAllocation(ResourceAllocation resourceAllocation) {
        this.resourceAllocation = resourceAllocation;
    }
}
