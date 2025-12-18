package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "resources",
    uniqueConstraints = @UniqueConstraint(columnNames = "resourceName")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Resource name required")
    @Column(nullable = false, unique = true)
    private String resourceName;

    @NotBlank(message = "Resource type required")
    @Column(nullable = false)
    private String resourceType;

    @Min(value = 1, message = "Capacity must be >= 1")
    @Column(nullable = false)
    private Integer capacity;

    private String location;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
