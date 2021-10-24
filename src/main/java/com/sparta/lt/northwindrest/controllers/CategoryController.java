package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.CategoryDescriptionDTO;
import com.sparta.lt.northwindrest.data.mappingservices.CategoryService;
import com.sparta.lt.northwindrest.entities.CategoryEntity;
import com.sparta.lt.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    @GetMapping("/northwind/categories")
    public List<CategoryDescriptionDTO> getCategoryDescriptions() {
        return categoryService.getCategoryDescriptions();
    }

    @GetMapping("/northwind/categories/{id}")
    public List<CategoryDescriptionDTO> getCategoryDescriptionsById(@PathVariable Integer id) {
        return categoryService.getCategoryDescriptionsById(id);
    }
}