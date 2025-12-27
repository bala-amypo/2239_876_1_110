package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.time.LocalDateTime;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    boolean existsByResourceName(String name);
    List<Resource> findByResourceType(String type);
}
