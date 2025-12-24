package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "requested_by_id")
    private User requestedBy;
    
    private String resourceType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private String status = "PENDING";

    public ResourceRequest() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getRequestedBy() { return requestedBy; }
    public void setRequestedBy(User requestedBy) { this.requestedBy = requestedBy; }
    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}