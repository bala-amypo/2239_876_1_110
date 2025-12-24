package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    @Autowired
    private AllocationRuleService ruleService;

    @PostMapping
    public ResponseEntity<AllocationRule> createRule(@RequestBody AllocationRule rule) {
        AllocationRule createdRule = ruleService.createRule(rule);
        return ResponseEntity.ok(createdRule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllocationRule> getRule(@PathVariable Long id) {
        AllocationRule rule = ruleService.getRule(id);
        return ResponseEntity.ok(rule);
    }

    @GetMapping
    public ResponseEntity<List<AllocationRule>> getAllRules() {
        List<AllocationRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
}