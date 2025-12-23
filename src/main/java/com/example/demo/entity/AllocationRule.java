package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "allocation_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "ruleName")
    }
)
public class AllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleName;

    @NotBlank(message = "Rule type is required")
    private String ruleType; // FIRSTAVAILABLE, PRIORITYBASED, ROUNDROBIN

    @Min(value = 0, message = "Priority weight must be at least 0")
    private Integer priorityWeight;

    private LocalDateTime createdAt;

    // No-arg constructor
    public AllocationRule() {
        this.createdAt = LocalDateTime.now();
    }

    // Parameterized constructor
    public AllocationRule(String ruleName, String ruleType, Integer priorityWeight) {
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.priorityWeight = priorityWeight;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getPriorityWeight() {
        return priorityWeight;
    }

    public void setPriorityWeight(Integer priorityWeight) {
        this.priorityWeight = priorityWeight;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
