package com.sparta.lt.northwindrest.mappers;

import com.sparta.lt.northwindrest.dto.ShipperDTO;
import com.sparta.lt.northwindrest.entities.ShipperEntity;
import com.sparta.lt.northwindrest.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipperMapService {

    @Autowired
    ShipperRepository shipperRepository;

    public List<ShipperDTO> getAllShippers() {
        return shipperRepository
                .findAll()
                .stream()
                .map(this::convertToShipperDTO)
                .collect(Collectors.toList());
    }

    private ShipperDTO convertToShipperDTO(ShipperEntity shipperEntity) {
        return new ShipperDTO(shipperEntity);
    }

}
