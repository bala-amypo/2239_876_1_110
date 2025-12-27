package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.time.LocalDateTime;
import java.util.*;
public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {
    List<ResourceRequest> findByRequestedBy_Id(Long id);
    List<ResourceRequest> findByStartTimeBetween(LocalDateTime s, LocalDateTime e);
}