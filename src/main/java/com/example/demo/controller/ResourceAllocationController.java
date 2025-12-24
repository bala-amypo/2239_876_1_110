package com.example.demo.controller;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/allocations")
@Tag(name = "Resource Allocations", description = "CRUD operations for resource allocations")
public class ResourceAllocationController {
    private final ResourceAllocationService allocationService;

    public ResourceAllocationController(ResourceAllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping("/auto/{requestId}")
    @Operation(summary = "Auto allocate resource", description = "Automatically allocate a resource for a request")
    public ResourceAllocation autoAllocate(@PathVariable Long requestId) {
        return allocationService.autoAllocate(requestId);
    }

    @GetMapping
    @Operation(summary = "Get all allocations", description = "Retrieve all resource allocations")
    public List<ResourceAllocation> getAll() {
        return allocationService.getAllAllocations();
    }
}