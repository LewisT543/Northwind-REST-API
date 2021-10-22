package com.northwind.np.controllers;

import com.northwind.np.entities.CategoryEntity;
import com.northwind.np.entities.EmployeeEntity;
import com.northwind.np.entities.ProductEntity;
import com.northwind.np.entities.SupplierEntity;
import com.northwind.np.repositories.CategoryRepository;
import com.northwind.np.repositories.EmployeeRepository;
import com.northwind.np.repositories.ProductRepository;
import com.northwind.np.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private EmployeeRepository employeeRepository;
    private CategoryRepository categoryRepository;
    private SupplierRepository supplierRepository;
    private ProductRepository productRepository;

    @Autowired
    public TestController(EmployeeRepository employeeRepository,
                          CategoryRepository categoryRepository,
                          SupplierRepository supplierRepository,
                          ProductRepository productRepository) {
        this.employeeRepository = employeeRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/northwind/employees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/northwind/categories")
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/northwind/suppliers")
    public List<SupplierEntity> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @GetMapping("/northwind/products")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

}
