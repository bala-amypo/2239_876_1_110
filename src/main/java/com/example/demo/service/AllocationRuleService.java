package com.example.demo.service;

import com.example.demo.entity.*;

import java.util.List;

public interface AllocationRuleService {
    AllocationRule createRule(AllocationRule rule);
    AllocationRule getRule(Long id);
    List<AllocationRule> getAllRules();
}
