package com.group8.assetflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        }
)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Category name is required")
    @Size(min = 3, message = "Category name must be at least 3 characters")
    private String name;

    @Column(length = 255)
    private String description;
    
    @OneToMany(mappedBy = "category")
    private List<DigitalVendor> vendors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DigitalVendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<DigitalVendor> vendors) {
        this.vendors = vendors;
    }
}