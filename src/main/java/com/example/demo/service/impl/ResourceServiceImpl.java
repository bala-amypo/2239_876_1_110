package com.example.demo.service.impl;

import com.example.demo.dto.ResourceRequestDto;
import com.example.demo.dto.ResourceResponseDto;
import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public ResourceResponseDto createResource(ResourceRequestDto requestDto) {

        Resource resource = new Resource();
        resource.setName(requestDto.getName());
        resource.setType(requestDto.getType());

        Resource saved = resourceRepository.save(resource);

        return new ResourceResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getType()
        );
    }
}
