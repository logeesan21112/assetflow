package com.group8.assetflow.repository;

import com.group8.assetflow.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}