package com.sparta.lt.northwindrest.data.dtos;

import com.sparta.lt.northwindrest.entities.CategoryEntity;

public class CategoryDescriptionDTO {

    private String name;
    private String description;

    public CategoryDescriptionDTO(CategoryEntity categoryEntity) {
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

    @Override
    public String toString() {
        return "CategoryDescriptionDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
