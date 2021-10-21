package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.SupplierEntity;
import com.sparta.lt.northwindrest.repositories.SupplierRepository;
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

    // TODO: change what happens when params aren't valid
    // TODO: change how this works because logic is jank
    @GetMapping("/northwind/suppliers")
    public List<SupplierEntity> getSuppliersWithLocation(@RequestParam(required=false) Map<String,String> params) {
        System.out.println(params.entrySet());

        if(params.size() == 0) {
            return supplierRepository.findAll();
        }

        List<SupplierEntity> suppliers = new ArrayList<>();

        if(params.containsKey("city")) {
            supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getCity().equalsIgnoreCase(params.get("city")))
                    .forEach(suppliers::add);
        }

        if(params.containsKey("country")) {
            supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getCountry().equalsIgnoreCase(params.get("country")))
                    .forEach(suppliers::add);
        }

        if(params.containsKey("postCode")) {
            supplierRepository.findAll()
                    .stream()
                    .filter(supplierEntity -> supplierEntity.getPostalCode().equalsIgnoreCase(params.get("postCode")))
                    .forEach(suppliers::add);
        }

        return suppliers;
    }

    @GetMapping(value="/northwind/suppliers", params = {"title"})
    public List<SupplierEntity> getSuppliersByTitle(@RequestParam(required = false) String title) {
        if(title == null) {
            return supplierRepository.findAll();
        }
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getContactTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
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

    // TODO: change return type to optional maybe? depends if companyName is unique or not
    @GetMapping("/northwind/suppliers/{companyName}")
    public List<SupplierEntity> getSuppliersWithCompanyName(@PathVariable String companyName) {
        return supplierRepository.findAll()
                .stream()
                .filter(supplierEntity -> supplierEntity.getCompanyName().equalsIgnoreCase(companyName))
                .collect(Collectors.toList());
    }


}
