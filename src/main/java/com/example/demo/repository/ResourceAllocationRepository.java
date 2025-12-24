package com.example.demo.repository;

import com.example.demo.entity.ResourceAllocation;
import java.util.List;

public interface ResourceAllocationRepository {
    ResourceAllocation save(ResourceAllocation allocation);
    List<ResourceAllocation> findAll();
}