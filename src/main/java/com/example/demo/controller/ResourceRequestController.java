package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService service;

    @PostMapping("/{userId}")
    public ResourceRequest createRequest(
            @PathVariable Long userId,
            @RequestBody ResourceRequest request) {
        return service.createRequest(userId, request);
    }

    @GetMapping("/{userId}")
    public List<ResourceRequest> getRequests(@PathVariable Long userId) {
        return service.getRequests(userId);
    }

    @PutMapping("/{id}/status")
    public ResourceRequest updateRequestStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateRequestStatus(id, status);
    }
}
