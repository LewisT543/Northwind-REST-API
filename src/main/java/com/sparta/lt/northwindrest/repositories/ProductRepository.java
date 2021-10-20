package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}