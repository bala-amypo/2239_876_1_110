package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.exception.AllocationException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceAllocationRepository allocationRepository;
    private final ResourceRequestRepository requestRepository;
    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceAllocationServiceImpl(ResourceAllocationRepository allocationRepository,
                                         ResourceRequestRepository requestRepository,
                                         ResourceRepository resourceRepository) {
        this.allocationRepository = allocationRepository;
        this.requestRepository = requestRepository;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id: " + requestId));

        List<Resource> candidates = resourceRepository.findByResourceType(request.getResourceType());
        if (candidates.isEmpty()) {
            throw new AllocationException("No resources available for type: " + request.getResourceType());
        }

        Resource resource = candidates.get(0); // simple allocation logic
        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setResource(resource);
        allocation.setResourceRequest(request);
        allocation.setConflictFlag(false);
        allocation.setAllocatedAt(LocalDateTime.now());

        return allocationRepository.save(allocation);
    }

    @Override
    public ResourceAllocation getAllocation(Long id) {
        return allocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocation not found with id: " + id));
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepository.findAll();
    }
}
