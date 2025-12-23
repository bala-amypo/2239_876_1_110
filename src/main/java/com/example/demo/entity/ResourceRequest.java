package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.AssertTrue;

import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;

    // Many requests belong to one user
    @ManyToOne
    @JoinColumn(name = "requested_by", nullable = false)
    private User requestedBy;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @NotBlank(message = "Purpose is required")
    private String purpose;

    private String status;

    // One request can have one allocation
    @OneToOne(mappedBy = "resourceRequest", cascade = CascadeType.ALL)
    private ResourceAllocation resourceAllocation;

    // No-arg constructor
    public ResourceRequest() {
        this.status = "PENDING"; // default status
    }

    // Parameterized constructor
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

    // Validation: startTime must be before endTime
    @AssertTrue(message = "Start time must be before end time")
    public boolean isValidTimeRange() {
        if (startTime == null || endTime == null) {
            return true;
        }
        return startTime.isBefore(endTime);
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

    public ResourceAllocation getResourceAllocation() {
        return resourceAllocation;
    }

    public void setResourceAllocation(ResourceAllocation resourceAllocation) {
        this.resourceAllocation = resourceAllocation;
    }
}
