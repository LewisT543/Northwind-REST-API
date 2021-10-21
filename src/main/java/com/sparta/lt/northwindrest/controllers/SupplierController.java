package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.SupplierDTO;
import com.sparta.lt.northwindrest.data.mappingservices.SupplierMapService;
import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public List<SupplierDTO> getSupplierById(@PathVariable Integer supplierId) {
        return supplierMapService.getSupplierById(supplierId);
    }

    @GetMapping(value="/northwind/suppliers", params={"country"})
    public List<SupplierDTO> getSuppliersByCountry(@RequestParam String country) {
        return supplierMapService.getSuppliersByCountry(country);
    }

    @GetMapping(value="/northwind/suppliers", params={"city"})
    public List<SupplierDTO> getSuppliersByCity(@RequestParam String city) {
        return supplierMapService.getSuppliersByCity(city);
    }

    @GetMapping(value="/northwind/suppliers", params={"postcode"})
    public List<SupplierDTO> getSuppliersByPostcode(@RequestParam String postcode) {
        return supplierMapService.getSuppliersByPostcode(postcode);
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
