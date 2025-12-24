package com.example.demo.repository;

import com.example.demo.entity.ResourceRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ResourceRequestRepository {
    ResourceRequest save(ResourceRequest request);
    List<ResourceRequest> findByRequestedBy_Id(Long userId);
    Optional<ResourceRequest> findById(Long id);
    List<ResourceRequest> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}