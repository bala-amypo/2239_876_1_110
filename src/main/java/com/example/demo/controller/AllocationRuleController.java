package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import com.example.demo.dto.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    private final AllocationRuleService ruleService;

    @Autowired
    public AllocationRuleController(AllocationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // 1. Create a new Allocation Rule (Admin only)
    @PostMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> createRule(@RequestBody AllocationRule rule) {
        AllocationRule createdRule = ruleService.createRule(rule);
        return ResponseEntity.ok(new ApiResponse("Allocation rule created successfully with id: " + createdRule.getId()));
    }

    // 2. Get all Allocation Rules
    @GetMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AllocationRule>> getAllRules() {
        List<AllocationRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }

    // 3. Get Allocation Rule by ID
    @GetMapping("/{id}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AllocationRule> getRuleById(@PathVariable Long id) {
        AllocationRule rule = ruleService.getRule(id);
        return ResponseEntity.ok(rule);
    }
}
