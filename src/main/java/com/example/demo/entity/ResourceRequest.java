package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;   // ✅ ADD THIS

    private String status;

    public ResourceRequest() {}

    public Long getId() {
        return id;
    }

    public String getResourceType() {   // ✅ ADD THIS
        return resourceType;
    }

    public void setResourceType(String resourceType) { // ✅ ADD THIS
        this.resourceType = resourceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
