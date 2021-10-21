package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// TODO: add encoding/decoding to deal with whitespaces -> %20

@RestController
public class SupplierController {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/northwind/suppliers")
    public List<SupplierEntity> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @GetMapping("/northwind/suppliers/{supplierId}")
    public Optional<SupplierEntity> getSupplierById(@PathVariable Integer supplierId) {
        return supplierRepository.findById(supplierId);
    }

    @GetMapping(value="/northwind/suppliers", params={"country"})
    public List<SupplierEntity> getSuppliersByCountry(@RequestParam String country) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getCountry().contains(country))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/suppliers", params={"city"})
    public List<SupplierEntity> getSuppliersByCity(@RequestParam String city) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getCity().contains(city))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/suppliers", params={"postcode"})
    public List<SupplierEntity> getSuppliersByPostcode(@RequestParam String postcode) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getPostalCode().contains(postcode))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/suppliers", params = {"title"})
    public List<SupplierEntity> getSuppliersByTitle(@RequestParam String title) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getContactTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/suppliers", params={"companyName"})
    public List<SupplierEntity> getSuppliersByCompanyName(@RequestParam String companyName) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getCompanyName().contains(companyName))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/suppliers", params={"country", "city"})
    public List<SupplierEntity> getSuppliersByCountryAndCity(@RequestParam String country,
                                                             @RequestParam String city) {
        return supplierRepository.findAll().stream()
                .filter(supplierEntity -> supplierEntity.getCountry().contains(country))
                .filter(supplierEntity -> supplierEntity.getCity().contains(city))
                .collect(Collectors.toList());
    }
}
