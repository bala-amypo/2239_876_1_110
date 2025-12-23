package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService requestService;

    public ResourceRequestController(ResourceRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ResourceRequest> createRequest(
            @PathVariable Long userId,
            @RequestBody ResourceRequest request) {
        return ResponseEntity.ok(requestService.createRequest(userId, request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResourceRequest>> getRequestsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(requestService.getRequestsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceRequest> getRequest(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.getRequest(id));
    }

    @PutMapping("/status/{requestId}")
    public ResponseEntity<ResourceRequest> updateStatus(
            @PathVariable Long requestId,
            @RequestParam String status) {
        return ResponseEntity.ok(requestService.updateRequestStatus(requestId, status));
    }
}
