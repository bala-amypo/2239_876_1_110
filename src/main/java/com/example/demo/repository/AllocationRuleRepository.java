package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AllocationRuleRepository extends JpaRepository<AllocationRule, Long> {
    boolean existsByRuleName(String ruleName);
}
