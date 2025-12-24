package com.example.demo.repository;

import com.example.demo.entity.Resource;
import java.util.List;

public interface ResourceRepository {

    boolean existsByResourceName(String resourceName);

    List<Resource> findAll();

    List<Resource> findByResourceType(String resourceType);

    Resource save(Resource resource);
}
