import jakarta.persistence.*


import javax.validation.constraints.*
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "resource_table", uniqueConstraints = {
    @UniqueConstraint(columnNames = "resourceName", name = "unique_resource_name_constraint")
})
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "resourceName required")
    private String resourceName;

    @Column(nullable = false)
    @NotBlank(message = "resourceType required")
    private String resourceType;

    @Min(value = 1, message = "capacity >= 1")
    @NotNull
    private Integer capacity;

    private String location;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Default No-Args Constructor (required by JPA)
    public Resource() {
    }

    // All-Args Constructor (excluding auto-generated 'id')
    public Resource(String resourceName, String resourceType, Integer capacity, String location, LocalDateTime createdAt) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.capacity = capacity;
        this.location = location;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    // Usually do not set ID manually when using GenerationType.IDENTITY
    // public void setId(Long id) { this.id = id; }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
