package com.sparta.lt.northwindrest.services;

import com.sparta.lt.northwindrest.dto.ShipperDTO;
import com.sparta.lt.northwindrest.entities.ShipperEntity;
import com.sparta.lt.northwindrest.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository repository;

    public List<ShipperDTO> getAllShipperDTO() {
        return repository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ShipperDTO> getShippersById(Integer id) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getId().equals(id))
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ShipperDTO> getShippersByCompany(String company) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getCompanyName().contains(company))
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ShipperDTO> getShippersByPhone(String phone) {
        return repository.findAll()
                .stream()
                .filter(e -> e.getPhone().equals(phone)) // or contains maybe?
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private ShipperDTO convertEntityToDTO(ShipperEntity entity) {
        return new ShipperDTO(entity);
    }
}
