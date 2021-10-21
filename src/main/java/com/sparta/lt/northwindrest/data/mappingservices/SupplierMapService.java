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
