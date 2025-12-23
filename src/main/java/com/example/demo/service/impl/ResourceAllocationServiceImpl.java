package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ResourceAllocationServiceImpl {

    @Autowired
    private ResourceRepository resourceRepository;

    public ResourceAllocationServiceImpl() {
    }

    public Resource allocateResource(String type) {

        Resource resource = resourceRepository.findFirstByType(type);

        if (resource == null) {
            throw new IllegalArgumentException("Resource not found");
        }

        return resource;
    }
}
