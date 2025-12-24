package com.example.demo.repository;

import com.example.demo.entity.Resource;
import java.util.List;

public interface ResourceRepository {
    boolean existsByResourceName(String resourceName);
    Resource save(Resource resource);
    List<Resource> findAll();
    List<Resource> findByResourceType(String resourceType);
}