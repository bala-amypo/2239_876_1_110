package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResourceAllocationServiceImpl 
        implements ResourceAllocationService {

    @Autowired
    private ResourceRequestRepository requestRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceAllocationRepository allocationRepository;

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {

        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Request not found"));

        Resource resource = resourceRepository
                .findFirstByResourceType(request.getResourceType())
                .orElseThrow(() ->
                        new IllegalArgumentException("No resource available"));

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);
        allocation.setResource(resource);
        allocation.setAllocatedAt(LocalDateTime.now());
        allocation.setConflictFlag(false);

        request.setStatus("ALLOCATED");

        return allocationRepository.save(allocation);
    }

    @Override
    public ResourceAllocation manualAllocate(Long requestId, Long resourceId) {

        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Request not found"));

        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found"));

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);
        allocation.setResource(resource);
        allocation.setAllocatedAt(LocalDateTime.now());
        allocation.setConflictFlag(false);

        request.setStatus("ALLOCATED");

        return allocationRepository.save(allocation);
    }

    @Override
    public void releaseAllocation(Long allocationId) {

        ResourceAllocation allocation = allocationRepository.findById(allocationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Allocation not found"));

        allocationRepository.delete(allocation);
    }
}
