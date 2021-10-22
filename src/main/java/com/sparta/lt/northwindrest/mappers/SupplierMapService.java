package com.sparta.lt.northwindrest.mappers;

import com.sparta.lt.northwindrest.dto.SupplierDTO;
import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierMapService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository
                .findAll()
                .stream()
                .map(this::convertToSupplierDTO)
                .collect(Collectors.toList());
    }

    private SupplierDTO convertToSupplierDTO(SupplierEntity supplierEntity) {
        return new SupplierDTO(supplierEntity);
    }


}
