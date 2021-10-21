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
    /*private final CustomerRepository customerRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/northwind/customer")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(@RequestParam(required=false) String name,
                                                @RequestParam(required=false) String country) {
        if (name == null && country == null)
            return customerRepository.findAll();
        if (name != null && country == null)
            return customerRepository.findAll()
                    .stream()
                    .filter(customerEntity -> customerEntity.getContactName().contains(name))
                    .collect(Collectors.toList());
        if (name == null && country != null)
            return customerRepository.findAll()
                    .stream()
                    .filter(customerEntity -> customerEntity.getCountry().contains(country))
                    .collect(Collectors.toList());
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getContactName().contains(name)
                        && customerEntity.getCountry().contains(country))
                .collect(Collectors.toList());
    }

    @GetMapping("/northwind/customers/{customerId}")
    public Optional<CustomerEntity> getCustomersById(@PathVariable String customerId) {
        return customerRepository.findById(customerId);
    }*/
}
