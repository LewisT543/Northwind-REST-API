package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.CustomerEntity;
import com.sparta.lt.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/northwind/customers")
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(value="/northwind/customers", params={"name"})
    @ResponseBody
    public List<CustomerEntity> getCustomersByName(@RequestParam String name) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getContactName().contains(name))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/customers", params={"country"})
    @ResponseBody
    public List<CustomerEntity> getCustomersByCountry(@RequestParam String country) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getCountry().contains(country))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/customers", params={"name", "country"})
    @ResponseBody
    public List<CustomerEntity> getCustomersByNameAndCountry(@RequestParam String name,
                                                             @RequestParam String country) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getContactName().contains(name))
                .filter(customerEntity -> customerEntity.getCountry().contains(country))
                .collect(Collectors.toList());
    }

    @GetMapping("/northwind/customers/{customerId}")
    public Optional<CustomerEntity> getCustomersById(@PathVariable String customerId) {
        return customerRepository.findById(customerId);
    }
}