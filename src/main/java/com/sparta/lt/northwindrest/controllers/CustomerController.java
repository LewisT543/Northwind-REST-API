package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.dto.CustomerDTO;
import com.sparta.lt.northwindrest.entities.CustomerEntity;
import com.sparta.lt.northwindrest.mappers.CustomerMapService;
import com.sparta.lt.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    private CustomerMapService customerMapService;

    @GetMapping(value="/northwind/customers")
    @ResponseBody
    public List<CustomerDTO> getAllCustomers(@RequestParam String name, @RequestParam(required = false) String title,
                                             @RequestParam(required = false) String region,
                                                @RequestParam(required=false) String country) {

        List<CustomerDTO> customers = new ArrayList<>();

        if (title == null && country == null & region == null) {
            System.err.println("1");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getContactName() != null && c.getContactName().contains(name))
                    customers.add(c);
            }
        } else if (title == null && country == null ) {
            System.err.println("2");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getRegion() != null && c.getContactName() != null) {
                    if (c.getContactName().contains(name) && c.getRegion().contains(region)) {
                        customers.add(c);
                    }
                }
            }
        } else if (title == null && region == null) {
            System.err.println("3");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getCountry() != null && c.getContactName() != null) {
                    if (c.getContactName().contains(name) && c.getCountry().contains(country)) {
                        customers.add(c);
                    }
                }
            }
        } else if (title == null) {
            System.err.println("4");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getContactName() != null && c.getCountry() != null && c.getRegion() != null) {
                    if (c.getContactName().contains(name) && c.getCountry().contains(country)
                            && c.getRegion().contains(region)) {
                        customers.add(c);
                    }
                }
            }
        } else if (country == null && region == null) {
            System.err.println("5");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getContactTitle() != null && c.getContactName() != null) {
                    if (c.getContactName().contains(name) && c.getContactTitle().contains(title)) {
                        customers.add(c);
                    }
                }
            }
        } else if (country == null) {
            System.err.println("6");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getContactName() != null && c.getContactTitle() != null && c.getRegion() != null) {
                    if (c.getContactName().contains(name) && c.getContactTitle().contains(title)
                            && c.getRegion().contains(region)) {
                        customers.add(c);
                    }
                }
            }
        } else if (region == null) {
            System.err.println("7");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getContactName() != null && c.getContactTitle() != null && c.getCountry() != null) {
                    if (c.getContactName().contains(name) && c.getContactTitle().contains(title)
                            && c.getCountry().contains(country)) {
                        customers.add(c);
                    }
                }
            }
        } else if (name != null && title != null && country != null && region != null) {
            System.err.println("8");
            for (CustomerDTO c : customerMapService.getAllCustomers()) {
                if (c.getContactName() != null && c.getContactTitle() != null &&
                        c.getCountry() != null && c.getRegion() != null) {
                    if (c.getContactName().contains(name) && c.getContactTitle().contains(title)
                            && c.getCountry().contains(country) && c.getRegion().contains(region)) {
                        customers.add(c);
                    }
                }
            }
        }
        return customers;
    }

    @GetMapping("/northwind/customers/{customerId}")
    public List<CustomerDTO> getCustomersById(@PathVariable Optional<String> customerId) {
        if (customerId.isPresent()) {
            return customerMapService
                    .getAllCustomers()
                    .stream()
                    .filter((c) -> c.getId().equals(customerId.get()))
                    .collect(Collectors.toList());
        }else return null;
    }

    @GetMapping("/northwind/customers/all")
    public List<CustomerDTO> getCustomers() {
        return customerMapService.getAllCustomers();
    }
}