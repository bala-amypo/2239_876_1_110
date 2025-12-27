package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceAllocationService;
import java.util.List;

public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceRequestRepository reqRepo;
    private final ResourceRepository resRepo;
    private final ResourceAllocationRepository allocRepo;

    public ResourceAllocationServiceImpl(ResourceRequestRepository r,
                                         ResourceRepository res,
                                         ResourceAllocationRepository a) {
        this.reqRepo = r;
        this.resRepo = res;
        this.allocRepo = a;
    }

    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest req = reqRepo.findById(requestId).orElseThrow();
        List<Resource> resources = resRepo.findByResourceType(req.getResourceType());

        if (resources.isEmpty())
            throw new RuntimeException("No resource available");

        ResourceAllocation alloc = new ResourceAllocation();
        alloc.setRequest(req);
        alloc.setResource(resources.get(0));
        return allocRepo.save(alloc);
    }

    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
