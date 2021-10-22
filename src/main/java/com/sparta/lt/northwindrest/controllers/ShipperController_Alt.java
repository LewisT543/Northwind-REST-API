package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.dto.ShipperDTO;
import com.sparta.lt.northwindrest.services.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipperController_Alt {

    private final ShipperService service;

    @Autowired
    public ShipperController_Alt(ShipperService service) {
        this.service = service;
    }

    @GetMapping("/northwind/shippers")
    public List<ShipperDTO> getAllShippers() {
        return service.getAllShipperDTO();
    }

    @GetMapping("/northwind/shippers/{id}")
    public List<ShipperDTO> getShippersById(@PathVariable Integer id) {
        return service.getShippersById(id);
    }

    @GetMapping(value = "/northwind/shippers", params = {"company"})
    public List<ShipperDTO> getShippersByCompany(@RequestParam String company) {
        return service.getShippersByCompany(company);
    }

    @GetMapping(value = "/northwind/shippers", params = {"phone"})
    public List<ShipperDTO> getShippersByPhone(@RequestParam String phone) {
        return service.getShippersByPhone(phone);
    }


}
