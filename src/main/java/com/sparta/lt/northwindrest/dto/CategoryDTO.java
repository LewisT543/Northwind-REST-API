package com.sparta.lt.northwindrest.dto;

import com.sparta.lt.northwindrest.entities.CategoryEntity;

public class CategoryDTO {

    private String category;
    private String desc;
    // TODO: how do picture

    public CategoryDTO(CategoryEntity entity) {
        this.category = entity.getCategoryName();
        this.desc = entity.getDescription();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
