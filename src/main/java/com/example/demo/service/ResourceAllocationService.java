package com.example.demo.service;

import com.example.demo.entity.ResourceAllocation;

public interface ResourceAllocationService {

    ResourceAllocation autoAllocate(Long requestId);

    ResourceAllocation manualAllocate(Long requestId, Long resourceId);

    void releaseAllocation(Long allocationId);
}
