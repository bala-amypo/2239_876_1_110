package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource createResource(Resource resource) {
        if (resource.getResourceName() == null || resource.getResourceType() == null || resource.getCapacity() == null) {
            throw new RuntimeException("Invalid resource");
        }
        if (resourceRepository.existsByResourceName(resource.getResourceName())) {
            throw new RuntimeException("Resource already exists");
        }
        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}