// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class ResourceAllocation {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Resource resource;

//     @OneToOne
//     private ResourceRequest request;

//     private LocalDateTime allocatedAt;

//     private Boolean conflictFlag;

//     private String notes;

//     @PrePersist
//     public void generateTime() {
//         this.allocatedAt = LocalDateTime.now();
//     }

//     // getters and setters
//     public Long getId() {
//         return id;
//     }

//     public Resource getResource() {
//         return resource;
//     }
    
//     public void setResource(Resource resource) {
//         this.resource = resource;
//     }

//     public ResourceRequest getRequest() {
//         return request;
//     }
    
//     public void setRequest(ResourceRequest request) {
//         this.request = request;
//     }

//     public LocalDateTime getAllocatedAt() {
//         return allocatedAt;
//     }

//     public Boolean getConflictFlag() {
//         return conflictFlag;
//     }

//     public void setConflictFlag(Boolean conflictFlag) {
//         this.conflictFlag = conflictFlag;
//     }

//     public String getNotes() {
//         return notes;
//     }
    
//     public void setNotes(String notes) {
//         this.notes = notes;
//     }
// }
