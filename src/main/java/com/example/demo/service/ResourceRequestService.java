package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;
import java.util.List;

public interface ResourceRequestService {

    // Create a new resource request for a user
    ResourceRequest createRequest(Long userId, ResourceRequest request);

    // Get a single resource request by ID
    ResourceRequest getRequest(Long requestId);

    // Get all requests for a specific user
    List<ResourceRequest> getRequestsByUser(Long userId);

    // Update the status of a request (PENDING, APPROVED, REJECTED)
    ResourceRequest updateRequestStatus(Long requestId, String status);
}
