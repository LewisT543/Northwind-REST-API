package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductsEntity, Integer> {
}