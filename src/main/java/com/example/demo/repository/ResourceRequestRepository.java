package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.entity.ResourceRequest;

public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {

   List<ResourceRequest> findByRequestedById(Long userId);

    List<ResourceRequest> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
