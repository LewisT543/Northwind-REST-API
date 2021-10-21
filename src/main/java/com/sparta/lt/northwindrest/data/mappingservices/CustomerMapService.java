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

    // BE WARNED THIS ISN'T FINISHED

    private CustomerDTO convertCustomerEntityToCustomerDTO(CustomerEntity customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setContactName(customer.getContactName());
        customerDTO.setCompanyName(customer.getCompanyName());
        customerDTO.setContactTitle(customer.getContactTitle());
        customerDTO.setContactName(customer.getContactName());
        customerDTO.setContactName(customer.getContactName());
    }
}
