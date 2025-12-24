package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Resource Requests", description = "CRUD operations for resource requests")
public class ResourceRequestController {
    private final ResourceRequestService requestService;

    public ResourceRequestController(ResourceRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/user/{userId}")
    @Operation(summary = "Create request", description = "Create a new resource request for a user")
    public ResourceRequest create(@PathVariable Long userId, @RequestBody ResourceRequest request) {
        return requestService.createRequest(userId, request);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get user requests", description = "Get all requests by user ID")
    public List<ResourceRequest> getByUser(@PathVariable Long userId) {
        return requestService.getRequestsByUser(userId);
    }

    @PutMapping("/{requestId}/status")
    @Operation(summary = "Update request status", description = "Update the status of a resource request")
    public ResourceRequest updateStatus(@PathVariable Long requestId, @RequestParam String status) {
        return requestService.updateRequestStatus(requestId, status);
    }
}