package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AllocationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleService {

    private final AllocationRuleRepository ruleRepository;

    // ⚠️ Constructor order EXACT
    public AllocationRuleService(AllocationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public AllocationRule createRule(AllocationRule rule) {
        if (ruleRepository.existsByRuleName(rule.getRuleName())) {
            throw new ValidationException("rule exists");
        }
        if (rule.getPriorityWeight() != null && rule.getPriorityWeight() < 0) {
            throw new ValidationException("priority must be >= 0");
        }
        return ruleRepository.save(rule);
    }

    public AllocationRule getRule(Long id) {
        return ruleRepository.findById(id).orElse(null);
    }

    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
