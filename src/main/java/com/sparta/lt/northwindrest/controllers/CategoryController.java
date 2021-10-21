package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.CategoryEntity;
import com.sparta.lt.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/northwind/categories")
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/northwind/categories/{categoryId}")
    public Optional<CategoryEntity> getCategoriesById(@PathVariable Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }
}