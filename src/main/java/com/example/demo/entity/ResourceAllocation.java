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
    private ResourceRequest request;
    private LocalDateTime allocatedAt;
    private Boolean conflictFlag;
    private String notes;

    public ResourceAllocation() {}

    public ResourceAllocation(Resource resource, ResourceRequest request, Boolean conflictFlag, String notes) {
        this.resource = resource;
        this.request = request;
        this.conflictFlag = conflictFlag;
        this.notes = notes;
    }

    @PrePersist
    public void prePersist() {
        this.allocatedAt = LocalDateTime.now();
    }

    // getters and setters
}
