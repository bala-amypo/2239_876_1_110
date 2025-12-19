package com.example.demo.repository;

import com.example.demo.entity.ResourceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {

    // Find all requests made by a specific user
    List<ResourceRequest> findByRequestedById(Long userId);

    // Find all requests within a specific time range
    List<ResourceRequest> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
