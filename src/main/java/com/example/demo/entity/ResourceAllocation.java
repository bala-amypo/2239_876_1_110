package com.example.demo.entity;

import java.time.LocalDateTime;

public class ResourceAllocation {
    private Long id;
    private Resource resource;
    private ResourceRequest request;
    private String notes;
    private LocalDateTime allocatedAt = LocalDateTime.now();

    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }

    public ResourceRequest getRequest() { return request; }
    public void setRequest(ResourceRequest request) { this.request = request; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getAllocatedAt() { return allocatedAt; }
}
