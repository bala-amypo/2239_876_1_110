package com.example.demo.service.impl;

import com.example.demo.service.ResourceService;
import com.example.demo.entity.Resource;
import com.example.demo.dto.ResourceRequestDto;
import com.example.demo.repository.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public ResourceServiceImpl() {
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource createResource(ResourceRequestDto dto) {
        Resource r = new Resource();
        r.setResourceName(dto.getResourceName());
        r.setResourceType(dto.getResourceType());
        r.setCapacity(dto.getCapacity());
        return resourceRepository.save(r);
    }
}
