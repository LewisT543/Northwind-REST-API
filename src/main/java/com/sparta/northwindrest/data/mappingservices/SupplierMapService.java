package com.sparta.northwindrest.data.mappingservices;

import com.sparta.northwindrest.data.dtos.SupplierDTO;
import com.sparta.northwindrest.entities.SupplierEntity;
import com.sparta.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierMapService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierDTO> getAllSupplierDTO() {
        try {
            return supplierRepository.findAll()
                    .stream()
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bad api endpoint", e);
        }
    }

    public List<SupplierDTO> getSupplierById(int supplierId) {
        try {
            return supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getId().equals(supplierId))
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid supplier ID", e);
        }
    }

    public List<SupplierDTO> getSuppliersByRegionCountryCity(String country, String city, String postCode) {
        List<SupplierDTO> suppliers = new ArrayList();

        if (city == null && postCode == null) {
            for (SupplierEntity s : supplierRepository.findAll()) {
                if (s.getCountry() != null && s.getCountry().equals(country)) {
                    suppliers.add(new SupplierDTO(s));
                }
            }
        } else if (city != null && postCode == null) {
            for (SupplierEntity s : supplierRepository.findAll()) {
                if (s.getCity() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getCity().equals(city)) {
                        suppliers.add(new SupplierDTO(s));
                    }
                }
            }
        } else if (city == null) {
            for (SupplierEntity s : supplierRepository.findAll()) {
                if (s.getPostalCode() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getPostalCode().equals(postCode)) {
                        suppliers.add(new SupplierDTO(s));
                    }
                }
            }
        } else {
            for (SupplierEntity s : supplierRepository.findAll()) {
                if (s.getPostalCode() != null && s.getCity() != null && s.getPostalCode() != null) {
                    if (s.getCountry().equals(country) && s.getCity().equals(city)
                            && s.getPostalCode().equals(postCode)) {
                        suppliers.add(new SupplierDTO(s));
                    }
                }
            }
        }
        return suppliers;
    }

    public List<SupplierDTO> getSuppliersByTitle(String title) {
        try {
            return supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getContactTitle().equalsIgnoreCase(title))
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "title not found", e);
        }
    }

    public List<SupplierDTO> getSuppliersByCompanyName(String companyName) {
        try {
            return supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getCompanyName().contains(companyName))
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "company not found", e);
        }
    }

    public List<SupplierDTO> getSuppliersByCountryAndCity(String country, String city) {
        try {
            return supplierRepository.findAll().stream()
                    .filter(supplierEntity -> supplierEntity.getCountry().contains(country))
                    .filter(supplierEntity -> supplierEntity.getCity().contains(city))
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "check city and country not found", e);
        }
    }

    private SupplierDTO convertSupplierEntityToSupplierDTO(SupplierEntity supplier) {
        return new SupplierDTO(supplier);
    }
}
