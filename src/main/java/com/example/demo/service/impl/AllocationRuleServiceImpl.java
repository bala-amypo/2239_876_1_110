package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository allocationRuleRepository;

    public AllocationRuleServiceImpl(AllocationRuleRepository allocationRuleRepository) {
        this.allocationRuleRepository = allocationRuleRepository;
    }

    @Override
    public AllocationRule createRule(AllocationRule rule) {

        if (allocationRuleRepository.existsByRuleName(rule.getRuleName())) {
            throw new IllegalArgumentException("Rule already exists");
        }

        if (rule.getPriorityWeight() < 0) {
            throw new IllegalArgumentException("Invalid priority");
        }

        return allocationRuleRepository.save(rule);
    }

    @Override
    public AllocationRule getRule(Long id) {
        return allocationRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return allocationRuleRepository.findAll();
    }
}
