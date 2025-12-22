package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.dto.ApiResponse;
import com.example.demo.service.ResourceRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService service;

    public ResourceRequestController(ResourceRequestService service) {
        this.service = service;
    }

   
    @PostMapping("/{userId}")
    public ApiResponse createRequest(@PathVariable Long userId, @RequestBody ResourceRequest request) {
        ResourceRequest created = service.createRequest(userId, request);
        return new ApiResponse(true, "Request created successfully", created);
    }

   
    @GetMapping("/{id}")
    public ResourceRequest getRequest(@PathVariable Long id) {
        return service.getRequest(id);
    }

    @GetMapping("/user/{userId}")
    public List<ResourceRequest> getRequestsByUser(@PathVariable Long userId) {
        return service.getRequestsByUser(userId);
    }

    @PutMapping("/status/{requestId}")
    public ApiResponse updateRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
        ResourceRequest updated = service.updateRequestStatus(requestId, status);
        return new ApiResponse(true, "Request status updated", updated);
    }
}
