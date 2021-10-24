package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.SupplierDTO;
import com.sparta.lt.northwindrest.data.mappingservices.SupplierMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SupplierController {
    @Autowired
    private SupplierMapService supplierMapService;

    @GetMapping("/northwind/supplier/{supplierID}")
    public List<SupplierDTO> getSupplierByID(@PathVariable Optional<Integer> supplierID) {
        if (supplierID.isPresent())
            return supplierMapService.getAllSupplierDTO();
        else return null;
    }

    @GetMapping("northwind/supplier")
    public List<SupplierDTO> sortSuppliersByRegionCountryCity(
            @RequestParam String country, @RequestParam(required = false) String city,
            @RequestParam(required = false) String postCode) {

        List<SupplierDTO> suppliers = new ArrayList();

        if (city == null && postCode == null) {
            for (SupplierDTO s : supplierMapService.getAllSupplierDTO()) {
                if (s.getCountry() != null && s.getCountry().equals(country)) {
                    suppliers.add(s);
                }
            }
        } else if (city != null && postCode == null) {
            for (SupplierDTO s : supplierMapService.getAllSupplierDTO()) {
                if (s.getCity() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getCity().equals(city)) {
                        suppliers.add(s);
                    }
                }
            }
        } else if (city == null) {
            for (SupplierDTO s : supplierMapService.getAllSupplierDTO()) {
                if (s.getPostalCode() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getPostalCode().equals(postCode)) {
                        suppliers.add(s);
                    }
                }
            }
        } else {
            for (SupplierDTO s : supplierMapService.getAllSupplierDTO()) {
                if (s.getPostalCode() != null && s.getCity() != null && s.getPostalCode() != null) {
                    if (s.getCountry().equals(country) && s.getCity().equals(city)
                            && s.getPostalCode().equals(postCode)) {
                        suppliers.add(s);
                    }
                }
            }
        }
        return suppliers;
    }

    //TODO: change return type to optional maybe? depends if companyName is unique or not
    @GetMapping(value = "/northwind/suppliers", params = {"name"})
    public List<SupplierDTO> getSuppliersWithCompanyName(@RequestParam String name) {
        List<SupplierDTO> suppliers = new ArrayList<>();

        for (SupplierDTO s : supplierMapService.getAllSupplierDTO()) {
            if (s.getCompanyName() != null && s.getCompanyName().equals(name)) {
                suppliers.add(s);
            }
        }

        return suppliers;
    }  

    @GetMapping("/northwind/suppliers")
    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapService.getAllSupplierDTO();
    }
}
