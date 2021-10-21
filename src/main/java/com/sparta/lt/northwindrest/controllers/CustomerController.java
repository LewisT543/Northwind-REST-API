package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.CustomerDTO;
import com.sparta.lt.northwindrest.data.mappingservices.CustomerMapService;
import com.sparta.lt.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerMapService customerMapService;

    @Autowired
    CustomerController(CustomerMapService customerMapService) {
        this.customerMapService = customerMapService;
    }

    @GetMapping("/northwind/customers")
    public List<CustomerDTO> getAllCustomers() {
        return customerMapService.getAllCustomerDTO();
    }

    @GetMapping(value="/northwind/customers", params={"name"})
    @ResponseBody
    public List<CustomerDTO> getCustomersByName(@RequestParam String name) {
        return customerMapService.getCustomersByName(name);
    }

    @GetMapping(value="/northwind/customers", params={"country"})
    @ResponseBody
    public List<CustomerDTO> getCustomersByCountry(@RequestParam String country) {
        return customerMapService.getCustomersByCountry(country);
    }

    @GetMapping(value="/northwind/customers", params={"name", "country"})
    @ResponseBody
    public List<CustomerDTO> getCustomersByNameAndCountry(@RequestParam String name,
                                                          @RequestParam String country) {
        return customerMapService.getCustomersByNameAndCountry(name, country);
    }

    @GetMapping("/northwind/customers/{customerId}")
    public CustomerDTO getCustomersById(@PathVariable String customerId) {
        return customerMapService.getCustomersById(customerId);
    }
}