package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}