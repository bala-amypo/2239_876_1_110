package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource createResource(Resource resource) {
        // Validate resourceType
        if (resource.getResourceType() == null || resource.getResourceType().trim().isEmpty()) {
            throw new ValidationException("Resource type must be provided.");
        }

        // Validate capacity
        if (resource.getCapacity() == null || resource.getCapacity() < 1) {
            throw new ValidationException("Resource capacity must be at least 1.");
        }

        // Check for duplicate resource name
        if (resourceRepository.existsByResourceName(resource.getResourceName())) {
            throw new ValidationException("Resource with name '" + resource.getResourceName() + "' already exists.");
        }

        // Save resource
        return resourceRepository.save(resource);
    }

    @Override
    public Resource getResource(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id " + id));
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}
