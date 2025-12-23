package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import com.example.demo.dto.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService requestService;

    @Autowired
    public ResourceRequestController(ResourceRequestService requestService) {
        this.requestService = requestService;
    }

    // 1. Create a resource request for a user
    @PostMapping("/{userId}")
    // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ResourceRequest> createRequest(
            @PathVariable Long userId,
            @RequestBody ResourceRequest request) {
        ResourceRequest created = requestService.createRequest(userId, request);
        return ResponseEntity.ok(created);
    }

    // 2. List requests for a specific user
    @GetMapping("/user/{userId}")
    // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ResourceRequest>> getRequestsByUser(@PathVariable Long userId) {
        List<ResourceRequest> requests = requestService.getRequestsByUser(userId);
        return ResponseEntity.ok(requests);
    }

    // 3. Get a single request by ID
    @GetMapping("/{id}")
    // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ResourceRequest> getRequestById(@PathVariable Long id) {
        ResourceRequest request = requestService.getRequest(id);
        return ResponseEntity.ok(request);
    }

    // 4. Update request status (Admin approves/rejects)
    @PutMapping("/status/{requestId}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResourceRequest> updateRequestStatus(
            @PathVariable Long requestId,
            @RequestParam String status) {
        ResourceRequest updated = requestService.updateRequestStatus(requestId, status);
        return ResponseEntity.ok(updated);
    }
}
