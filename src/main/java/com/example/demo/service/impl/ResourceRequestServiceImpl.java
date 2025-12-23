package com.example.demo.service.impl;

import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.stereotype.Service;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository resourceRequestRepository;

    public ResourceRequestServiceImpl(ResourceRequestRepository resourceRequestRepository) {
        this.resourceRequestRepository = resourceRequestRepository;
    }
}
