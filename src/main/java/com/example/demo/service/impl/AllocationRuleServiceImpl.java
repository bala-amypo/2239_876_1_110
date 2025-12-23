package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    @Autowired
    private AllocationRuleRepository ruleRepository;

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        // Check for duplicate rule name
        if (ruleRepository.existsByRuleName(rule.getRuleName())) {
            throw new ValidationException("Allocation rule with name '" + rule.getRuleName() + "' already exists.");
        }

        // Save and return
        return ruleRepository.save(rule);
    }

    @Override
    public AllocationRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocation rule not found with id " + id));
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
