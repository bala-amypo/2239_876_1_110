package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AllocationRule;

public interface AllocationRuleService {

    AllocationRule createRule(AllocationRule rule);

    AllocationRule getRule(Long id);

    List<AllocationRule> getAllRules();
}
