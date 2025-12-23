package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_allocations")
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resource resource;

    @OneToOne
    @JoinColumn(unique = true)
    private ResourceRequest request;

    private LocalDateTime allocatedAt;

    private Boolean conflictFlag;

    private String notes;

    public ResourceAllocation() {
    }

    public ResourceAllocation(Resource resource, ResourceRequest request,
                              Boolean conflictFlag, String notes) {
        this.resource = resource;
        this.request = request;
        this.conflictFlag = conflictFlag;
        this.notes = notes;
    }

    @PrePersist
    public void onAllocate() {
        this.allocatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Resource getResource() {
        return resource;
    }

    public ResourceRequest getRequest() {
        return request;
    }

    public LocalDateTime getAllocatedAt() {
        return allocatedAt;
    }

    public Boolean getConflictFlag() {
        return conflictFlag;
    }

    public String getNotes() {
        return notes;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setRequest(ResourceRequest request) {
        this.request = request;
    }

    public void setConflictFlag(Boolean conflictFlag) {
        this.conflictFlag = conflictFlag;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
