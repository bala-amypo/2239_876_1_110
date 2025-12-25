package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Allocation Rules", description = "CRUD operations for allocation rules")
public class AllocationRuleController {
    private final AllocationRuleService ruleService;

    public AllocationRuleController(AllocationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    @Operation(summary = "Create rule", description = "Create a new allocation rule")
    public AllocationRule create(@RequestBody AllocationRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get rule by ID", description = "Retrieve an allocation rule by ID")
    public AllocationRule getById(@PathVariable Long id) {
        return ruleService.getRule(id);
    }

    @GetMapping
    public List<AllocationRule> getAll() {
        return ruleService.getAllRules();
    }
}