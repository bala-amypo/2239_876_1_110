package com.example.demo.service.impl;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.service.ResourceAllocationService;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceAllocationRepository allocationRepository;

    public ResourceAllocationServiceImpl(ResourceAllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    @Override
    public ResourceAllocation allocate(ResourceAllocation allocation) {
        allocation.setAllocatedAt(LocalDateTime.now());
        return allocationRepository.save(allocation);
    }
}
