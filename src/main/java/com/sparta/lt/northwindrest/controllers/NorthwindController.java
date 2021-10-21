package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.CustomerEntity;
import com.sparta.lt.northwindrest.entities.ProductEntity;
import com.sparta.lt.northwindrest.repositories.CustomerRepository;
import com.sparta.lt.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class NorthwindController {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;


    @Autowired
    public NorthwindController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getCustomers(@RequestParam(required = false) String name) {
        if (name == null) {
            return customerRepository.findAll();
        }
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getContactName().contains(name))
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
}
