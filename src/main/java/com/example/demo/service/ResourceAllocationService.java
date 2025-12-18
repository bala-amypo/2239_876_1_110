package com.example.demo.service;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceAllocationService {

    private final ResourceRequestRepository requestRepository;
    private final ResourceRepository resourceRepository;
    private final ResourceAllocationRepository allocationRepository;

    // ⚠️ Constructor order EXACT
    public ResourceAllocationService(ResourceRequestRepository requestRepository,
                                     ResourceRepository resourceRepository,
                                     ResourceAllocationRepository allocationRepository) {
        this.requestRepository = requestRepository;
        this.resourceRepository = resourceRepository;
        this.allocationRepository = allocationRepository;
    }

    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest request = requestRepository.findById(requestId).orElse(null);

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);

        List<Resource> resources =
                resourceRepository.findByResourceType(request.getResourceType());

        if (!resources.isEmpty()) {
            allocation.setResource(resources.get(0)); // FIRST_AVAILABLE
            allocation.setConflictFlag(false);
            allocation.setNotes("Allocated using FIRST_AVAILABLE");
            request.setStatus("APPROVED");
        } else {
            allocation.setConflictFlag(true);
            allocation.setNotes("No resource available");
            request.setStatus("REJECTED");
        }

        return allocationRepository.save(allocation);
    }

    public ResourceAllocation getAllocation(Long id) {
        return allocationRepository.findById(id).orElse(null);
    }

    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepository.findAll();
    }
}
