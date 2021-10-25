package com.sparta.northwindrest.data.mappingservices;

import com.sparta.northwindrest.data.dtos.CategoryDTO;
import com.sparta.northwindrest.entities.CategoryEntity;
import com.sparta.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryMapService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategoryDescriptions() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToCategoryDescriptionDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoryDescriptionsById(Integer id) {
        return categoryRepository.findById(id)
                .stream()
                .map(this::convertToCategoryDescriptionDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoryDescriptionsByKeyword(List<String> keywords) {
        List<CategoryEntity> entities = new ArrayList<>();
        for (String keyword : keywords) {
            for (CategoryEntity entity : categoryRepository.findAll()) {
                String k = keyword.toLowerCase();
                if (entity.getCategoryName().toLowerCase().contains(k) || entity.getDescription().toLowerCase().contains(k)) {
                    if(!entities.contains(entity)) {
                        entities.add(entity);
                    }
                }
            }
        }
        return entities.stream().map(this::convertToCategoryDescriptionDTO).collect(Collectors.toList());
    }

    private CategoryDTO convertToCategoryDescriptionDTO(CategoryEntity categoryEntity) {
        return new CategoryDTO(categoryEntity);
    }

}