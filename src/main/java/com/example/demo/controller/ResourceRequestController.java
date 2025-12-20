package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService service;

    public ResourceRequestController(ResourceRequestService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public ResourceRequest createRequest(
            @PathVariable Long userId,
            @RequestBody ResourceRequest request) {
        return service.createRequest(userId, request);
    }

    @GetMapping("/user/{userId}")
    public List<ResourceRequest> getRequestsByUser(@PathVariable Long userId) {
        return service.getRequestsByUser(userId);
    }

    @GetMapping("/{id}")
    public ResourceRequest getRequest(@PathVariable Long id) {
        return service.getRequest(id);
    }

    @PutMapping("/status/{requestId}")
    public ResourceRequest updateStatus(
            @PathVariable Long requestId,
            @RequestParam String status) {
        return service.updateRequestStatus(requestId, status);
    }
}

