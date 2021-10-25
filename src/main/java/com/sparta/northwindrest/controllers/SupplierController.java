package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.data.dtos.SupplierDTO;
import com.sparta.northwindrest.data.mappingservices.SupplierMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SupplierController {
    private final SupplierMapService supplierMapService;

    @Autowired
    public SupplierController(SupplierMapService supplierMapService) {
        this.supplierMapService = supplierMapService;
    }

    @GetMapping("/northwind/suppliers")
    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapService.getAllSupplierDTO();
    }

    @GetMapping("/northwind/suppliers/{supplierId}")
    public List<SupplierDTO> getSupplierById(@PathVariable int supplierId) {
        return supplierMapService.getSupplierById(supplierId);
    }

    @GetMapping(value="/northwind/suppliers", params={"country"})
    public List<SupplierDTO> getSuppliersByRegionCountryCity(@RequestParam String country,
                                                             @RequestParam(required = false) String city,
                                                             @RequestParam(required = false) String postCode) {
        return supplierMapService.getSuppliersByRegionCountryCity(country, city, postCode);
    }

    @GetMapping(value="/northwind/suppliers", params = {"title"})
    public List<SupplierDTO> getSuppliersByTitle(@RequestParam String title) {
        return supplierMapService.getSuppliersByTitle(title);
    }

    @GetMapping(value="/northwind/suppliers", params={"companyName"})
    public List<SupplierDTO> getSuppliersByCompanyName(@RequestParam String companyName) {
        return supplierMapService.getSuppliersByCompanyName(companyName);
    }

    @GetMapping(value="/northwind/suppliers", params={"country", "city"})
    public List<SupplierDTO> getSuppliersByCountryAndCity(@RequestParam String country,
                                                             @RequestParam String city) {
        return supplierMapService.getSuppliersByCountryAndCity(country, city);
    }
}
