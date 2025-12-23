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
    private ResourceRequest request;

    private LocalDateTime allocatedAt;

    private Boolean conflict;

    private String notes;

    // No-arg constructor
    public ResourceAllocation() {
    }

    // Parameterized constructor
    public ResourceAllocation(Resource resource, ResourceRequest request, Boolean conflict, String notes) {
        this.resource = resource;
        this.request = request;
        this.conflict = conflict;
        this.notes = notes;
    }

    // Automatically set allocation time on persist
    @PrePersist
    public void onAllocate() {
        if (this.allocatedAt == null) {
            this.allocatedAt = LocalDateTime.now();
        }
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }

    public ResourceRequest getRequest() { return request; }
    public void setRequest(ResourceRequest request) { this.request = request; }

    public LocalDateTime getAllocatedAt() { return allocatedAt; }
    public void setAllocatedAt(LocalDateTime allocatedAt) { this.allocatedAt = allocatedAt; }

    public Boolean getConflict() { return conflict; }
    public void setConflict(Boolean conflict) { this.conflict = conflict; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
