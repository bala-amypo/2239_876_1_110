package com.example.demo.service;

import com.example.demo.dto.ResourceRequestDto;
import com.example.demo.dto.ResourceResponseDto;

public interface ResourceService {

    ResourceResponseDto createResource(ResourceRequestDto requestDto);

    ResourceResponseDto getResourceById(Long id);
}
