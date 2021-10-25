package com.sparta.northwindrest.data.mappingservices;

import com.sparta.northwindrest.data.dtos.CategoryDTO;
import com.sparta.northwindrest.entities.CategoryEntity;
import com.sparta.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryMapService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategoryDescriptions() {
        try {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }
    }

    public List<CategoryDTO> getCategoryDescriptionsById(int id) {
        try {
        return categoryRepository.findAll()
                .stream()
                .filter(categoryEntity -> categoryEntity.getId().equals(id))
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category id not found", e);
        }
    }

    private CategoryDTO convertToCategoryDTO(CategoryEntity categoryEntity) {
        return new CategoryDTO(categoryEntity);
    }

}