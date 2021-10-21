package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.ShipperEntity;
import com.sparta.lt.northwindrest.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShipperController {

    private final ShipperRepository shipperRepository;

    @Autowired
    public ShipperController(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @GetMapping("/northwind/shippers")
    public List<ShipperEntity> getAllShippers() {
        return shipperRepository.findAll();
    }

    // TODO: implement what happens when optional is null
    @GetMapping("/northwind/shippers/{shipperId}")
    public List<ShipperEntity> getShippersById(@PathVariable Integer shipperId) {
        return shipperRepository.findAll()
                .stream()
                .filter(shipperEntity -> shipperEntity.getId().equals(shipperId))
                .collect(Collectors.toList());
    }

}
