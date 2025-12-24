package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {
    private final ResourceRequestService requestService;

    public ResourceRequestController(ResourceRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/user/{userId}")
    public ResourceRequest create(@PathVariable Long userId, @RequestBody ResourceRequest request) {
        return requestService.createRequest(userId, request);
    }

    @GetMapping("/user/{userId}")
    public List<ResourceRequest> getByUser(@PathVariable Long userId) {
        return requestService.getRequestsByUser(userId);
    }

    @PutMapping("/{requestId}/status")
    public ResourceRequest updateStatus(@PathVariable Long requestId, @RequestParam String status) {
        return requestService.updateRequestStatus(requestId, status);
    }
}