package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourceRequestService;

import java.util.Collections;
import java.util.List;

public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository requestRepository;
    private final UserRepository userRepository;

    public ResourceRequestServiceImpl(ResourceRequestRepository requestRepository,
                                      UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        return request;
    }

    @Override
    public List<ResourceRequest> getRequests(Long userId) {
        return Collections.emptyList();
    }

    @Override
    public void updateRequestStatus(Long requestId, String status) {
        // stub
    }
}
