package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ResourceRequest;

public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {

    List<ResourceRequest> findByRequestedBy_Id(Long id);

    List<ResourceRequest> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
