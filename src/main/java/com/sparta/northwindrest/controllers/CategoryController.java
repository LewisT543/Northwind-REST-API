package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.data.dtos.CategoryDTO;
import com.sparta.northwindrest.data.mappingservices.CategoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryMapService categoryService;

    public CategoryMapService getCategoryService() {
        return categoryService;
    }

    @GetMapping("/northwind/categories")
    public List<CategoryDTO> getCategoryDescriptions(@RequestParam(name = "keyword", required = false) List<String> keywords) {
        if(keywords != null) {
            return categoryService.getCategoryDescriptionsByKeyword(keywords);
        }
        return categoryService.getCategoryDescriptions();
    }

    @GetMapping("/northwind/categories/{id}")
    public List<CategoryDTO> getCategoryDescriptionsById(@PathVariable Integer id) {
        return categoryService.getCategoryDescriptionsById(id);
    }
}