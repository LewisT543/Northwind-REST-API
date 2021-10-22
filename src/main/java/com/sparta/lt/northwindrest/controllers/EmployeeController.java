package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.EmployeeDTO;
import com.sparta.lt.northwindrest.data.mappingservices.EmployeeMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeMapService employeeMapService;

    @Autowired
    public EmployeeController(EmployeeMapService employeeMapService) {
        this.employeeMapService = employeeMapService;
    }

    @GetMapping("/northwind/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapService.getAllEmployeeDTO();
    }

    @GetMapping(value="/northwind/employees", params={"employeeId"})
    public List<EmployeeDTO> getEmployeesByEmployeeId(@RequestParam Integer employeeId) {
        return employeeMapService.getEmployeesById(employeeId);
    }

    @GetMapping(value="/northwind/employees", params={"firstName"})
    public List<EmployeeDTO> getEmployeesByFirstName(@RequestParam String firstName) {
        return employeeMapService.getEmployeesByFirstName(firstName);
    }

    @GetMapping(value="/northwind/employees", params={"lastName"})
    @ResponseBody
    public List<EmployeeDTO> getEmployeesByLastName(@RequestParam String lastName) {
        return employeeMapService.getEmployeesByLastName(lastName);
    }

    @GetMapping(value="/northwind/employees", params={"country"})
    @ResponseBody
    public List<EmployeeDTO> getEmployeesByCountry(@RequestParam String country) {
        return employeeMapService.getEmployeesByCountry(country);
    }

    @GetMapping(value="/northwind/employees", params={"firstName", "country"})
    @ResponseBody
    public List<EmployeeDTO> getEmployeesByFirstNameAndCountry(@RequestParam String firstName,
                                                                  @RequestParam String country) {
        return employeeMapService.getEmployeesByFirstNameAndCountry(firstName, country);
    }

    @GetMapping(value="/northwind/employees", params={"lastName", "country"})
    @ResponseBody
    public List<EmployeeDTO> getEmployeesByLastNameAndCountry(@RequestParam String lastName,
                                                                 @RequestParam String country) {
        return employeeMapService.getEmployeesByLastNameAndCountry(lastName, country);
    }

    @GetMapping(value="/northwind/employees", params={"firstName", "lastName"})
    @ResponseBody
    public List<EmployeeDTO> getEmployeesByFirstAndLastName(@RequestParam String firstName,
                                                               @RequestParam String lastName) {
        return employeeMapService.getEmployeesByFirstAndLastName(firstName, lastName);
    }
}