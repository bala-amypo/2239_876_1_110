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

    @Autowired
    private ResourceAllocationRepository allocationRepository;

    @Autowired
    private ResourceRequestRepository requestRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        // Load the ResourceRequest
        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource request not found with id " + requestId));

        // Find candidate resources by type
        List<Resource> candidates = resourceRepository.findByResourceType(request.getResourceType());
        if (candidates.isEmpty()) {
            throw new AllocationException("No available resources of type '" + request.getResourceType() + "' for allocation.");
        }

        // For simplicity, pick the first available resource
        Resource allocatedResource = candidates.get(0);

        // Create allocation
        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setResource(allocatedResource);
        allocation.setRequest(request);
        allocation.setConflict(false); // Assuming no conflict logic implemented yet
        allocation.setAllocatedAt(LocalDateTime.now());

        // Save and return
        return allocationRepository.save(allocation);
    }

    @Override
    public ResourceAllocation getAllocation(Long id) {
        return allocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource allocation not found with id " + id));
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepository.findAll();
    }
}
