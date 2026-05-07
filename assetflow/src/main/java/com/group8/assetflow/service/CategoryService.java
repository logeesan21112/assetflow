package com.group8.assetflow.service;

import com.group8.assetflow.exception.CategoryAlreadyExistsException;
import com.group8.assetflow.model.Category;
import com.group8.assetflow.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        boolean exists = categoryRepository.existsByNameAndIdNot(
            category.getName(), 
            category.getId() == null ? -1L : category.getId()
        );
        if (exists) {
            throw new CategoryAlreadyExistsException("Category '" + category.getName() + "' already exists.");
        }
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}