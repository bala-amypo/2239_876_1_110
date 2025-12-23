package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ResourceAllocation;

public interface ResourceAllocationService {

    ResourceAllocation autoAllocate(Long requestId);

    ResourceAllocation getAllocation(Long id);

    List<ResourceAllocation> getAllAllocations();
}
