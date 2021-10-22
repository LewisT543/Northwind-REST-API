package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dtos.ShipperDTO;
import com.sparta.lt.northwindrest.entities.ShipperEntity;
import com.sparta.lt.northwindrest.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
