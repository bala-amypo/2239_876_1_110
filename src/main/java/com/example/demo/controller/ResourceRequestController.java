package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService requestService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<ResourceRequest> createRequest(@PathVariable Long userId, @RequestBody ResourceRequest request) {
        ResourceRequest createdRequest = requestService.createRequest(userId, request);
        return ResponseEntity.ok(createdRequest);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResourceRequest>> getRequestsByUser(@PathVariable Long userId) {
        List<ResourceRequest> requests = requestService.getRequestsByUser(userId);
        return ResponseEntity.ok(requests);
    }

    @PutMapping("/{requestId}/status")
    public ResponseEntity<ResourceRequest> updateRequestStatus(@PathVariable Long requestId, @RequestBody StatusUpdate statusUpdate) {
        ResourceRequest updatedRequest = requestService.updateRequestStatus(requestId, statusUpdate.getStatus());
        return ResponseEntity.ok(updatedRequest);
    }

    public static class StatusUpdate {
        private String status;

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}