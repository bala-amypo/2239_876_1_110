package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "resource_allocations",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "request_id")
    }
)
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many allocations can use the same resource
    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    // One allocation per request (unique)
    @OneToOne
    @JoinColumn(name = "request_id", nullable = false, unique = true)
    private ResourceRequest resourceRequest;

    private LocalDateTime allocatedAt;

    private Boolean conflictFlag;

    private String notes;

    // No-arg constructor
    public ResourceAllocation() {
    }

    // Parameterized constructor
    public ResourceAllocation(
            Resource resource,
            ResourceRequest resourceRequest,
            Boolean conflictFlag,
            String notes) {

        this.resource = resource;
        this.resourceRequest = resourceRequest;
        this.conflictFlag = conflictFlag;
        this.notes = notes;
    }

    // Automatically set allocation time
    @PrePersist
    public void onAllocate() {
        this.allocatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
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
