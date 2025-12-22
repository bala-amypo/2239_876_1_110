package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public Resource create(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @GetMapping
    public List<Resource> getAll() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public Resource getById(@PathVariable Long id) {
        // ✅ FIXED method name
        return resourceService.getResourceById(id);
    }

    @PutMapping("/{id}")
    public Resource update(@PathVariable Long id, @RequestBody Resource resource) {
        return resourceService.updateResource(id, resource);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resourceService.deleteResource(id);
    }
}
