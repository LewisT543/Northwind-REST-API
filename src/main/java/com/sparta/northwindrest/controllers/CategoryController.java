package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.data.dtos.CategoryDTO;
import com.sparta.northwindrest.data.mappingservices.CategoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private CategoryMapService categoryMapService;

    @Autowired
    CategoryController(CategoryMapService categoryMapService) {
        this.categoryMapService = categoryMapService;
    }

    @GetMapping("/northwind/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryMapService.getCategoryDescriptions();
    }

    @GetMapping("/northwind/categories/{categoryId}")
    public List<CategoryDTO> getCategoriesById(@PathVariable int categoryId) {
        return categoryMapService.getCategoryDescriptionsById(categoryId);
    }
}