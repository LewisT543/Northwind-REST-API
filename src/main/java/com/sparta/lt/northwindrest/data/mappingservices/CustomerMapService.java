package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dtos.CustomerDTO;
import com.sparta.lt.northwindrest.entities.CustomerEntity;
import com.sparta.lt.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerMapService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomerDTO() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersByName(String name) {
        return customerRepository.findAll()
                .stream()
                .filter(customerDTO -> customerDTO.getContactName().contains(name))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersByCountry(String country) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getCountry().contains(country))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public List<CustomerDTO> getCustomersByNameAndCountry(String name, String country) {
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getContactName().contains(name))
                .filter(customerEntity -> customerEntity.getCountry().contains(country))
                .map(this::convertCustomerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomersById(String customerId) {
        if (customerRepository.findById(customerId).isPresent())
            return convertCustomerEntityToCustomerDTO(customerRepository.findById(customerId).get());
        return null;
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
