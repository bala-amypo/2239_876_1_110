package com.example.demo.controller;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class ResourceAllocationController {

    @Autowired
    private ResourceAllocationService allocationService;

    @PostMapping("/auto/{requestId}")
    public ResponseEntity<ResourceAllocation> autoAllocate(@PathVariable Long requestId) {
        ResourceAllocation allocation = allocationService.autoAllocate(requestId);
        return ResponseEntity.ok(allocation);
    }

    @GetMapping
    public ResponseEntity<List<ResourceAllocation>> getAllAllocations() {
        List<ResourceAllocation> allocations = allocationService.getAllAllocations();
        return ResponseEntity.ok(allocations);
    }
}