package com.example.demo.service.impl;

import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.stereotype.Service;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceAllocationRepository resourceAllocationRepository;
    private final ResourceRepository resourceRepository;
    private final ResourceRequestRepository resourceRequestRepository;

    public ResourceAllocationServiceImpl(
            ResourceAllocationRepository resourceAllocationRepository,
            ResourceRepository resourceRepository,
            ResourceRequestRepository resourceRequestRepository
    ) {
        this.resourceAllocationRepository = resourceAllocationRepository;
        this.resourceRepository = resourceRepository;
        this.resourceRequestRepository = resourceRequestRepository;
    }
}
