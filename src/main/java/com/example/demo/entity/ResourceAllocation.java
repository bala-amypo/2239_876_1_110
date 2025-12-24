package com.example.demo.entity;

import java.time.LocalDateTime;

public class ResourceAllocation {
    private Long id;
    private ResourceRequest request;
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