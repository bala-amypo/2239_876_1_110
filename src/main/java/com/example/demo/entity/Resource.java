package com.example.demo.entity;

public class Resource {
    private Long id;
    private String resourceName;
    private String resourceType;
    private Integer capacity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getResourceName() { return resourceName; }
    public void setResourceName(String resourceName) { this.resourceName = resourceName; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) {
        if (capacity == null || capacity < 1)
            throw new RuntimeException("Capacity must be >=1");
        this.capacity = capacity;
    }
}
