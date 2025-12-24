package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);
        return ResponseEntity.ok(createdResource);
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }
}