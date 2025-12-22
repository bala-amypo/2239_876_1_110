package com.example.demo.repository;

import com.example.demo.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Optional<Resource> findFirstByType(String type);
}
