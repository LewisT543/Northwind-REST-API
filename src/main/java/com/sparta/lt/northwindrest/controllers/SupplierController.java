package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.dto.SupplierDTO;
import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.mappers.SupplierMapService;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// TODO: add encoding/decoding to deal with whitespaces -> %20

@RestController
public class SupplierController {

    @Autowired
    private SupplierMapService supplierMapService;

    // TODO: change what happens when params aren't valid
    // TODO: change how this works because logic is jank
    @GetMapping("/northwind/supplier/{supplierID}")
    public List<SupplierDTO> getSupplierByID(@PathVariable Optional<Integer> supplierID) {
        if (supplierID.isPresent())
            return supplierMapService.getAllSuppliers();
        else return null;
    }

    @GetMapping("northwind/supplier")
    public List<SupplierDTO> sortSuppliersByRegionCountryCity(
            @RequestParam String country, @RequestParam(required = false) String city,
            @RequestParam(required = false) String postCode) {

        List<SupplierDTO> suppliers = new ArrayList();

        if (city == null && postCode == null) {
            for (SupplierDTO s : supplierMapService.getAllSuppliers()) {
                if (s.getCountry() != null && s.getCountry().equals(country)) {
                    suppliers.add(s);
                }
            }
        } else if (city != null && postCode == null) {
            for (SupplierDTO s : supplierMapService.getAllSuppliers()) {
                if (s.getCity() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getCity().equals(city)) {
                        suppliers.add(s);
                    }
                }
            }
        } else if (city == null) {
            for (SupplierDTO s : supplierMapService.getAllSuppliers()) {
                if (s.getPostalCode() != null && s.getCountry() != null) {
                    if (s.getCountry().equals(country) && s.getPostalCode().equals(postCode)) {
                        suppliers.add(s);
                    }
                }
            }
        } else {
            for (SupplierDTO s : supplierMapService.getAllSuppliers()) {
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

    // jesus don't look at this
    /*@GetMapping("/northwind/suppliers")
    public List<SupplierEntity> getSuppliers(@RequestParam(required = false) Optional<String> city,
                                             @RequestParam(required = false) Optional<String> country) {

        List<Optional<String>> optionalParams = Arrays.asList(city, country);
        List<String> filteredParams = optionalParams.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println("number of valid params: " + filteredParams.size());
        if(filteredParams.size() == 0) { // if no valid params, return all suppliers
            return supplierRepository.findAll();
        } else {
            System.out.println("doing things");
            Predicate<SupplierEntity> matches = null;
            System.out.println("looping");
            for (int i = 0; i < filteredParams.size(); i++) {
                Predicate<SupplierEntity> match = null;
                System.out.println(filteredParams.get(i).toLowerCase());
                switch (filteredParams.get(i).toLowerCase()) {
                    case "city":
                        match = s -> s.getCity().equalsIgnoreCase("london");
                        break;
                    case "country":
                        match = s -> s.getCountry().equalsIgnoreCase("uk");
                        break;
                    default: // param not valid, but this should never happen
                        System.out.println("error in switch statement");
                        //return supplierRepository.findAll();
                }
                if(i == 0) { // make a predicate for the first param
                    matches = match;
                } else { // add any remaining params
                    matches.or(match);
                }
            }
            System.out.println("looping finished");
            List<SupplierEntity> suppliers = supplierRepository.findAll()
                    .stream()
                    .filter(matches)
                    .collect(Collectors.toList());
            System.out.println(suppliers.size());
            suppliers.stream().forEach(s -> System.out.println(s));
            return suppliers;
        }
    }*/

    //TODO: change return type to optional maybe? depends if companyName is unique or not
    @GetMapping(value = "/northwind/suppliers", params = {"name"})
    public List<SupplierDTO> getSuppliersWithCompanyName(@RequestParam String name) {
        List<SupplierDTO> suppliers = new ArrayList<>();

        for (SupplierDTO s : supplierMapService.getAllSuppliers()) {
            if (s.getCompanyName() != null && s.getCompanyName().equals(name)) {
                suppliers.add(s);
            }
        }

        return suppliers;
    }


}
