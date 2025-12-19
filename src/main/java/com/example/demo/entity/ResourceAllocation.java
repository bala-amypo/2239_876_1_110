package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_allocations")
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many allocations can refer to one resource
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    // One allocation per request
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", unique = true, nullable = false)
    private ResourceRequest resourceRequest;

    private LocalDateTime allocatedAt;

    private Boolean conflictFlag;

    private String notes;

    // No-arg constructor
    public ResourceAllocation() {
    }

    // Parameterized constructor
    public ResourceAllocation(Resource resource, ResourceRequest resourceRequest, Boolean conflictFlag, String notes) {
        this.resource = resource;
        this.resourceRequest = resourceRequest;
        this.conflictFlag = conflictFlag;
        this.notes = notes;
    }

    // Automatically set allocatedAt before saving
    @PrePersist
    public void prePersist() {
        this.allocatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public ResourceRequest getResourceRequest() {
        return resourceRequest;
    }

    public void setResourceRequest(ResourceRequest resourceRequest) {
        this.resourceRequest = resourceRequest;
    }

    public LocalDateTime getAllocatedAt() {
        return allocatedAt;
    }

    public Boolean getConflictFlag() {
        return conflictFlag;
    }

    public void setConflictFlag(Boolean conflictFlag) {
        this.conflictFlag = conflictFlag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
