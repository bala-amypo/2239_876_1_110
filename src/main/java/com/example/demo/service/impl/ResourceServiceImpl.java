package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.exception.ResourceNotFoundException;
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
        if (resourceRepository.existsByResourceName(resource.getResourceName())) {
            throw new IllegalArgumentException("Resource name already exists");
        }
        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public Resource updateResource(Long id, Resource resource) {

        Resource existing = resourceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found"));

        existing.setResourceName(resource.getResourceName());
        existing.setResourceType(resource.getResourceType());
        existing.setCapacity(resource.getCapacity());
        existing.setLocation(resource.getLocation());

        return resourceRepository.save(existing);
    }

    @Override
    public void deleteResource(Long id) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found"));
        resourceRepository.delete(resource);
    }
}
