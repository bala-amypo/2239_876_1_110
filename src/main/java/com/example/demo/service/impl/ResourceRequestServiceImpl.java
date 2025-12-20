package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.stereotype.Service;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository repository;

    public ResourceRequestServiceImpl(ResourceRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResourceRequest updateStatus(Long id, String status) {
        ResourceRequest request = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ResourceRequest not found with id " + id));

        request.setStatus(status);
        return repository.save(request);
    }
}
