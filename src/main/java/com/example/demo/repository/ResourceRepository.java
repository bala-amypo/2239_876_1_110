package com.example.demo.repository;

import com.example.demo.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    // Check if a resource with the given name already exists
    boolean existsByResourceName(String resourceName);

    // Get all resources of a specific type
    List<Resource> findByResourceType(String resourceType);
}
