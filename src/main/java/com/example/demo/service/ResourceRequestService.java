package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;
import java.util.List;

public interface ResourceRequestService {

    ResourceRequest createRequest(Long userId, ResourceRequest request);

    List<ResourceRequest> getRequests(Long userId);

    // 🔧 FIXED
    ResourceRequest updateRequestStatus(Long requestId, String status);
}
