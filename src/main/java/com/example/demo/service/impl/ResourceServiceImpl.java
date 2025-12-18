package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    // constructor injection (order matters)
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource createResource(Resource resource) {
        if (resourceRepository.existsByResourceName(resource.getResourceName())) {
            throw new ValidationException("resource exists");
        }
        if (resource.getCapacity() == null || resource.getCapacity() < 1) {
            throw new ValidationException("capacity must be >= 1");
        }
        if (resource.getResourceType() == null) {
            throw new ValidationException("resourceType required");
        }
        return resourceRepository.save(resource);
    }

    @Override
    public Resource getResource(Long id) {
        return resourceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}
