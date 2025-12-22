package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository reqRepo;

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        // Example: find by requestedById
        return reqRepo.findByRequestedById(userId);
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        // 1. Find request
        ResourceRequest request = reqRepo.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));

        // 2. Update status
        request.setStatus(status);

        // 3. Save and return
        return reqRepo.save(request);
    }
}
