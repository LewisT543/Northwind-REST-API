package com.sparta.northwindrest.data.mappingservices;

import com.sparta.northwindrest.entities.CustomerEntity;
import com.sparta.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerMapService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomerDTO() {
        try {
            return customerRepository.findAll()
                    .stream()
                    .map(this::convertCustomerEntityToCustomerDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }
    }

    public List<CustomerDTO> getCustomersByName(String name) {
        return customerRepository.findAll()
                .stream()
                .filter(customerDTO -> customerDTO.getContactName().contains(name))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersByCountry(String country) {
        try {
            return customerRepository.findAll()
                    .stream()
                    .filter(customerEntity -> customerEntity.getCountry().contains(country))
                    .map(this::convertCustomerEntityToCustomerDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "country not found", e);
        }
    }

    public List<CustomerDTO> getCustomersByNameAndCountry(String name, String country) {
        try {
            return customerRepository.findAll()
                    .stream()
                    .filter(customerEntity -> customerEntity.getContactName().contains(name))
                    .filter(customerEntity -> customerEntity.getCountry().contains(country))
                    .map(this::convertCustomerEntityToCustomerDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "name and country not found", e);
        }
    }

    public List<CustomerDTO> getCustomersById(String customerId) {
        try {
            return customerRepository.findAll()
                    .stream()
                    .filter(customerEntity -> customerEntity.getId().equals(customerId))
                    .map(this::convertCustomerEntityToCustomerDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "costumer id not found", e);
        }
    }

    private CustomerDTO convertCustomerEntityToCustomerDTO(CustomerEntity customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setContactName(customer.getContactName());
        customerDTO.setCompanyName(customer.getCompanyName());
        customerDTO.setContactTitle(customer.getContactTitle());
        customerDTO.setCity(customer.getCity());
        customerDTO.setCountry(customer.getCountry());
        return customerDTO;
    }
}
