package com.example.demo.controller;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
import com.example.demo.dto.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class ResourceAllocationController {

    private final ResourceAllocationService allocationService;

    @Autowired
    public ResourceAllocationController(ResourceAllocationService allocationService) {
        this.allocationService = allocationService;
    }

    // 1. Automatically allocate a resource for a request
    @PostMapping("/auto/{requestId}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResourceAllocation> autoAllocate(@PathVariable Long requestId) {
        ResourceAllocation allocation = allocationService.autoAllocate(requestId);
        return ResponseEntity.ok(allocation);
    }

    // 2. Get all allocations
    @GetMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ResourceAllocation>> getAllAllocations() {
        List<ResourceAllocation> allocations = allocationService.getAllAllocations();
        return ResponseEntity.ok(allocations);
    }

    // 3. Get allocation by ID
    @GetMapping("/{id}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResourceAllocation> getAllocationById(@PathVariable Long id) {
        ResourceAllocation allocation = allocationService.getAllocation(id);
        return ResponseEntity.ok(allocation);
    }
}
