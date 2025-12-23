package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Check if a user with the given email already exists
    boolean existsByEmail(String email);

    // Find a user by email (used for authentication)
    Optional<User> findByEmail(String email);
}
