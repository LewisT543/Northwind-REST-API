package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.dto.CategoryDTO;
import com.sparta.lt.northwindrest.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController_Alt {

    private final CategoryService service;

    @Autowired
    public CategoryController_Alt(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/northwind/categories")
    public List<CategoryDTO> getAllCategories() {
        return service.getAllCategoryDTO();
    }

    @GetMapping("/northwind/categories/{id}")
    public List<CategoryDTO> getCategoriesById(@PathVariable Integer id) {
        return service.getCategoriesById(id);
    }

    @GetMapping("/northwind/categories/{name}")
    public List<CategoryDTO> getCategoriesByName(@PathVariable String name) {
        return service.getCategoriesByName(name);
    }

    @GetMapping(value = "/northwind/categories", params = {"desc"})
    public List<CategoryDTO> getCategoriesByDescription(@PathVariable String desc) {
        return service.getCategoriesByDescription(desc);
    }

}
