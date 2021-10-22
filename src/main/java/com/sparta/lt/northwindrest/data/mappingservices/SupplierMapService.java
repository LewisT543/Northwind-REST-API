package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dtos.SupplierDTO;
import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierMapService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierDTO> getAllSupplierDTO() {
        return supplierRepository.findAll()
                .stream()
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSupplierById(Integer supplierId) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getId().equals(supplierId))
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSuppliersByCountry(String country) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getCountry().contains(country))
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSuppliersByCity(String city) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getCity().contains(city))
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSuppliersByPostcode(String postcode) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getPostalCode().contains(postcode))
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSuppliersByTitle(String title) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getContactTitle().equalsIgnoreCase(title))
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSuppliersByCompanyName(String companyName) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getCompanyName().contains(companyName))
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    public List<SupplierDTO> getSuppliersByCountryAndCity(String country, String city) {
        return supplierRepository.findAll().stream()
                .filter(supplierEntity -> supplierEntity.getCountry().contains(country))
                .filter(supplierEntity -> supplierEntity.getCity().contains(city))
                .map(this::convertSupplierEntityToSupplierDTO)
                .collect(Collectors.toList());
    }

    private SupplierDTO convertSupplierEntityToSupplierDTO(SupplierEntity supplier) {
        return new SupplierDTO(supplier);
    }
}
