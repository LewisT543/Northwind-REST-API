package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.dto.ShipperDTO;
import com.sparta.lt.northwindrest.entities.ShipperEntity;
import com.sparta.lt.northwindrest.mappers.ShipperMapService;
import com.sparta.lt.northwindrest.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShipperController {

    @Autowired
    private ShipperMapService shipperMapService;


    //TODO: Testing required
    @GetMapping("/northwind/shippers/{shipperId}")
    public List<ShipperDTO> getShippersById(@PathVariable Optional<Integer> shipperId) {
        if (!shipperId.isPresent()) {
            return shipperMapService.getAllShippers();
        } else {
            List<ShipperDTO> shippers = new ArrayList<>();
            for (ShipperDTO s : shipperMapService.getAllShippers()) {
                if (s.getShipperID() != null && s.getShipperID() == shipperId.get()) {
                    shippers.add(s);
                    break;
                }
            }
            return shippers;
        }
    }

}
