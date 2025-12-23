package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.dto.ResourceRequestDto;
import com.example.demo.service.ResourceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<Resource> createResource(
            @RequestBody ResourceRequestDto dto) {

        Resource resource = resourceService.createResource(dto);
        return ResponseEntity.ok(resource);
    }
}
