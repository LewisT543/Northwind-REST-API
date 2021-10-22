package com.sparta.lt.northwindrest.services;

import com.sparta.lt.northwindrest.dto.CategoryDTO;
import com.sparta.lt.northwindrest.entities.CategoryEntity;
import com.sparta.lt.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryDTO> getAllCategoryDTO() {
        return repository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesById(Integer id) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getId().equals(id))
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesByName(String name) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getCategoryName().equalsIgnoreCase(name))
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesByDescription(String desc) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getCategoryName().contains(desc))
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private CategoryDTO convertEntityToDTO(CategoryEntity entity) {
        return new CategoryDTO(entity);
    }
}
