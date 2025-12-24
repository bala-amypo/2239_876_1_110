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
    @JoinColumn(name = "request_id")
    private ResourceRequest request;
    
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
    
    private String notes;
    private LocalDateTime allocatedAt = LocalDateTime.now();

    public ResourceAllocation() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ResourceRequest getRequest() { return request; }
    public void setRequest(ResourceRequest request) { this.request = request; }
    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public LocalDateTime getAllocatedAt() { return allocatedAt; }
    public void setAllocatedAt(LocalDateTime allocatedAt) { this.allocatedAt = allocatedAt; }
}