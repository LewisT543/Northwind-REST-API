package com.sparta.northwindrest.data.dtos;

import com.sparta.northwindrest.entities.CategoryEntity;

public class CategoryDTO {
    private String name;
    private String description;

    public CategoryDTO(CategoryEntity categoryEntity) {
        this.name = categoryEntity.getCategoryName();
        this.description = categoryEntity.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
