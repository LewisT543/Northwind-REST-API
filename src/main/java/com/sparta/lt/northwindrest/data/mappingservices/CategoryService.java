package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dtos.CategoryDescriptionDTO;
import com.sparta.lt.northwindrest.entities.CategoryEntity;
import com.sparta.lt.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDescriptionDTO> getCategoryDescriptions() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToCategoryDescriptionDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryDescriptionDTO> getCategoryDescriptionsById(int id) {
        return categoryRepository.findAll()
                .stream()
                .filter(categoryEntity -> categoryEntity.getId().equals(id))
                .map(this::convertToCategoryDescriptionDTO)
                .collect(Collectors.toList());
    }

    private CategoryDescriptionDTO convertToCategoryDescriptionDTO(CategoryEntity categoryEntity) {
        return new CategoryDescriptionDTO(categoryEntity);
    }

}
