package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resource resource;

    @ManyToOne
    private ResourceRequest request;

    private LocalDateTime allocatedAt;

    private boolean conflictFlag;

    
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

    public boolean isConflictFlag() {
        return conflictFlag;
    }

    // ---------- SETTERS ----------
    public void setId(Long id) {
        this.id = id;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setRequest(ResourceRequest request) {
        this.request = request;
    }

    public void setAllocatedAt(LocalDateTime allocatedAt) {
        this.allocatedAt = allocatedAt;
    }

    public void setConflictFlag(boolean conflictFlag) {
        this.conflictFlag = conflictFlag;
    }
}
