package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.mappingservices.ProductMapService;
import com.sparta.lt.northwindrest.entities.ProductEntity;
import com.sparta.lt.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapService productMapService;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductMapService productMapService){
        this.productRepository = productRepository;
        this.productMapService = productMapService;
    }

    @GetMapping("/northwind/products")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/northwind/products/{productId}")
    public Optional<ProductEntity> getProductById(@PathVariable Integer productId) {
        return productRepository.findById(productId);
    }

    @GetMapping("/northwind/products/{productName}")
    public List<ProductEntity> getProductByName(@PathVariable String productName) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getProductName().contains(productName))
                .collect(Collectors.toList());
    }

    @GetMapping("/northwind/products/inStock")
    public List<ProductEntity> getProductsInStock() {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getUnitsInStock() > 0)
                .collect(Collectors.toList());
    }

    @GetMapping("/northwind/products/outOfStock")
    public List<ProductEntity> getProductsOutOfStock() {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getUnitsInStock() == 0)
                .collect(Collectors.toList());
    }

    @GetMapping("/northwind/products/discontinued")
    public List<ProductEntity> getProductsDiscontinued() {
        return productRepository.findAll()
                .stream()
                .filter(ProductEntity::getDiscontinued)
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/products", params={"supplierId"})
    public List<ProductEntity> getProductsBySupplierId(@RequestParam Integer supplierId) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getSupplierID().equals(supplierId))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/products", params={"categoryId"})
    public List<ProductEntity> getProductsByCategoryId(@RequestParam Integer categoryId) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getCategoryID().equals(categoryId))
                .collect(Collectors.toList());
    }
}
