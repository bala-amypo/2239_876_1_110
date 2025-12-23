package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ResourceRequest;

public interface ResourceRequestService {

    ResourceRequest createRequest(Long userId, ResourceRequest request);

    List<ResourceRequest> getRequestsByUser(Long userId);

    ResourceRequest getRequest(Long id);

    ResourceRequest updateRequestStatus(Long requestId, String status);
}
