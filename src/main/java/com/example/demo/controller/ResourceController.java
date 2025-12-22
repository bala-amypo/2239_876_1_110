package com.example.demo.controller;

import com.example.demo.dto.ResourceRequestDto;
import com.example.demo.dto.ResourceResponseDto;
import com.example.demo.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<ResourceResponseDto> createResource(
            @RequestBody ResourceRequestDto requestDto) {

        ResourceResponseDto response =
                resourceService.createResource(requestDto);

        return ResponseEntity.ok(response);
    }
}
