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

    private String status;

    @OneToOne(mappedBy = "request")
    private ResourceAllocation allocation;

    public ResourceRequest() {
    }

    public ResourceRequest(String resourceType, User requestedBy,
                           LocalDateTime startTime, LocalDateTime endTime,
                           String purpose, String status) {
        this.resourceType = resourceType;
        this.requestedBy = requestedBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.purpose = purpose;
        this.status = status;
    }

    @PrePersist
    public void defaultStatus() {
        if (this.status == null) {
            this.status = "PENDING";
        }
    }

    public Long getId() {
        return id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
