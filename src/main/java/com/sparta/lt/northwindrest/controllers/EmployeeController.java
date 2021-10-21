package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.EmployeeEntity;
import com.sparta.lt.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/northwind/employees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping(value="/northwind/employees", params={"firstName"})
    @ResponseBody
    public List<EmployeeEntity> getEmployeesByFirstName(@RequestParam String firstName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/employees", params={"lastName"})
    @ResponseBody
    public List<EmployeeEntity> getEmployeesByLastName(@RequestParam String lastName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/employees", params={"country"})
    @ResponseBody
    public List<EmployeeEntity> getEmployeesByCountry(@RequestParam String country) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/employees", params={"firstName", "country"})
    @ResponseBody
    public List<EmployeeEntity> getEmployeesByFirstNameAndCountry(@RequestParam String firstName,
                                                                  @RequestParam(required=false) String country) {
        if (country == null)
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                    .collect(Collectors.toList());
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName)
                        && employeeEntity.getCountry().contains(country))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/employees", params={"lastName", "country"})
    @ResponseBody
    public List<EmployeeEntity> getEmployeesByLastNameAndCountry(@RequestParam String lastName,
                                                                 @RequestParam(required=false) String country) {
        if (country == null)
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                    .collect(Collectors.toList());
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName)
                        && employeeEntity.getCountry().contains(country))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/northwind/employees", params={"firstName", "lastName"})
    @ResponseBody
    public List<EmployeeEntity> getEmployeesByFirstAndLastName(@RequestParam(required=false) String firstName,
                                                               @RequestParam String lastName) {
        if (firstName == null)
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                    .collect(Collectors.toList());
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName)
                        && employeeEntity.getLastName().contains(lastName))
                .collect(Collectors.toList());
    }
}