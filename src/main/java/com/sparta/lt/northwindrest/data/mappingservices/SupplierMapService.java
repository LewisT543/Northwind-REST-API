package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dto.SupplierDTO;
import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
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

    public List<SupplierDTO> getSuppliersByCountry(String country) {
        try {
            return supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getCountry().contains(country))
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not recognised", e);
        }
    }

    public List<SupplierDTO> getSuppliersByCity(String city) {
        try {
            return supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getCity().contains(city))
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found", e);
        }
    }

    public List<SupplierDTO> getSuppliersByPostcode(String postcode) {
        try {
            return supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getPostalCode().contains(postcode))
                    .map(this::convertSupplierEntityToSupplierDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Postcode not found", e);
        }
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
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierName(supplier.getCompanyName());
        supplierDTO.setContactName(supplier.getContactName());
        supplierDTO.setContactTitle(supplier.getContactTitle());
        supplierDTO.setCountry(supplier.getCountry());
        supplierDTO.setCity(supplier.getCity());
        return supplierDTO;
    }
}
