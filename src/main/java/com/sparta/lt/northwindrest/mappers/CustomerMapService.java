package com.sparta.lt.northwindrest.mappers;

import com.sparta.lt.northwindrest.dto.CustomerDTO;
import com.sparta.lt.northwindrest.dto.SupplierDTO;
import com.sparta.lt.northwindrest.entities.CustomerEntity;
import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.repositories.CustomerRepository;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerMapService {
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(this::convertToCustomerDTO)
                .collect(Collectors.toList());
    }

    private CustomerDTO convertToCustomerDTO(CustomerEntity customerEntity) {
        return new CustomerDTO(customerEntity);
    }

}
