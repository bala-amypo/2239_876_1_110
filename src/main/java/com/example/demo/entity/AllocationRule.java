// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class AllocationRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String ruleName;

//     private String ruleType;
//     private Integer priorityWeight;
//     private LocalDateTime createdAt;

//     public AllocationRule() {
//     }

//     @PrePersist
//     public void onCreate() {
//         createdAt = LocalDateTime.now();
//     }

//     // Getters & Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getRuleName() {
//         return ruleName;
//     }
    
//     public void setRuleName(String ruleName) {
//         this.ruleName = ruleName;
//     }

//     public String getRuleType() {
//         return ruleType;
//     }
    
//     public void setRuleType(String ruleType) {
//         this.ruleType = ruleType;
//     }

//     public Integer getPriorityWeight() {
//         return priorityWeight;
//     }
    
//     public void setPriorityWeight(Integer priorityWeight) {
//         this.priorityWeight = priorityWeight;
//     }

//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }
// }
