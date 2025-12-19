package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {

    // 🔹 Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Resource Name (Unique)
    @Column(unique = true, nullable = false)
    private String resourceName;

    // 🔹 Resource Type (Mandatory)
    @NotBlank(message = "Resource type is mandatory")
    private String resourceType;

    // 🔹 Capacity (Must be >= 1)
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    // 🔹 Location
    private String location;

    // 🔹 Created Time
    private LocalDateTime createdAt;

    // 🔹 One Resource → Many ResourceAllocations
    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
    private List<ResourceAllocation> allocations;

    // 🔹 No-arg constructor
    public Resource() {
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Parameterized constructor
    public Resource(String resourceName, String resourceType, Integer capacity, String location) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.capacity = capacity;
        this.location = location;
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<ResourceAllocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<ResourceAllocation> allocations) {
        this.allocations = allocations;
    }
}
