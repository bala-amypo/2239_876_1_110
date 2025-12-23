package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ResourceRequest {

    @Id
    @GeneratedValue
    private Long id;

    private String resourceType;
    private String status;
    private String startTime;
    private String endTime;

    @ManyToOne
    private User requestedBy;

    public ResourceRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // 🔥 REQUIRED BY TESTS
    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }
}
