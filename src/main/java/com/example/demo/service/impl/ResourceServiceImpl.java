package com.example.demo.service.impl;

import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;

public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }
}
