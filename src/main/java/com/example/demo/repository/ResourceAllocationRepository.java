package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.time.LocalDateTime;
import java.util.*;
public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Long> {}