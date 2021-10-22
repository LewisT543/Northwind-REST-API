package com.sparta.lt.northwindrest.dunno.controllers;

import com.sparta.lt.northwindrest.dunno.entities.CustomerEntity;
import com.sparta.lt.northwindrest.dunno.entities.ProductEntity;
import com.sparta.lt.northwindrest.dunno.repositories.CustomerRepository;
import com.sparta.lt.northwindrest.dunno.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class NorthwindController {
    private final ProductRepository productRepository;


    @Autowired
    public NorthwindController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
}
