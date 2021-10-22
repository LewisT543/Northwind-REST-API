package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.ProductDTO;
import com.sparta.lt.northwindrest.data.mappingservices.ProductMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductMapService productMapService;

    @Autowired
    public ProductController(ProductMapService productMapService){
        this.productMapService = productMapService;
    }

    @GetMapping("/northwind/products")
    public List<ProductDTO> getAllProducts() {
        return productMapService.getAllProductDTO();
    }

    // public List<ProductDTO> getProductById(@PathVariable Optional<Integer> productId) - ASK ABOUT THIS
    @GetMapping("/northwind/products/{productId}")
    public List<ProductDTO> getProductById(@PathVariable Integer productId) {
        return productMapService.getProductById(productId);
    }

    @GetMapping(value="/northwind/products", params={"productName"})
    public List<ProductDTO> getProductByName(@RequestParam String productName) {
        return productMapService.getProductByName(productName);
    }

    @GetMapping("/northwind/products/inStock")
    public List<ProductDTO> getProductsInStock() {
        return productMapService.getProductsInStock();
    }

    @GetMapping("/northwind/products/outOfStock")
    public List<ProductDTO> getProductsOutOfStock() {
        return productMapService.getProductsOutOfStock();
    }

    @GetMapping("/northwind/products/discontinued")
    public List<ProductDTO> getProductsDiscontinued() {
        return productMapService.getProductsDiscontinued();
    }

    @GetMapping(value="/northwind/products", params={"supplierId"})
    public List<ProductDTO> getProductsBySupplierId(@RequestParam int supplierId) {
        return productMapService.getProductsBySupplierId(supplierId);
    }

    @GetMapping(value="/northwind/products", params={"categoryId"})
    public List<ProductDTO> getProductsByCategoryId(@RequestParam int categoryId) {
        return productMapService.getProductsByCategoryId(categoryId);
    }
}
