package com.group8.assetflow.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group8.assetflow.exception.CategoryAlreadyExistsException;
import com.group8.assetflow.model.Category;
import com.group8.assetflow.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        return "category/categories";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/form";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.getById(id));
        return "category/form";
    }

    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("category") Category category,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "category/form";
        }

        try {
            categoryService.save(category);
        } catch (CategoryAlreadyExistsException e) {
            model.addAttribute("duplicateError", e.getMessage());
            return "category/form";
        }

        redirectAttributes.addFlashAttribute("message", "Category saved successfully");
        return "redirect:/categories";
    }

    @GetMapping("/{id}/remove")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Category deleted successfully");
        return "redirect:/categories";
    }
}