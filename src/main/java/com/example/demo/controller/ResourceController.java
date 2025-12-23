package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;
import com.example.demo.dto.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    // 1. Create a new Resource (Admin only)
    @PostMapping
    // @PreAuthorize("hasRole('ADMIN')") // Enable when using Spring Security
    public ResponseEntity<ApiResponse> createResource(@RequestBody Resource resource) {
        Resource created = resourceService.createResource(resource);
        return ResponseEntity.ok(new ApiResponse("Resource created successfully with id: " + created.getId()));
    }

    // 2. Get all Resources (Admin or User)
    @GetMapping
    // @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    // 3. Get Resource by ID (Admin or User)
    @GetMapping("/{id}")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Resource resource = resourceService.getResource(id);
        return ResponseEntity.ok(resource);
    }
}
