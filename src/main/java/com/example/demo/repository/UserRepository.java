package com.example.demo.repository;

import com.example.demo.entity.*;
import java.time.LocalDateTime;
import java.util.*;

public interface UserRepository {
    boolean existsByEmail(String email);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
}
