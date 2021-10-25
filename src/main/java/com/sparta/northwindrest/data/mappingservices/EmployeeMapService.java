package com.sparta.northwindrest.data.mappingservices;

import com.sparta.northwindrest.data.dtos.EmployeeDTO;
import com.sparta.northwindrest.entities.EmployeeEntity;
import com.sparta.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeMapService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployeeDTO() {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }
    }

    public List<EmployeeDTO> getEmployeesById(Integer employeeId) {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getId().equals(employeeId))
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee id not found", e);
        }
    }

    public List<EmployeeDTO> getEmployeesByFirstName(String firstName) {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "firstname not found", e);
        }
    }

    public List<EmployeeDTO> getEmployeesByLastName(String lastName) {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "lastname not found", e);
        }
    }

    public List<EmployeeDTO> getEmployeesByCountry(String country) {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "country not found", e);
        }
    }

    public List<EmployeeDTO> getEmployeesByFirstNameAndCountry(String firstName, String country) {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                    .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "firstname and country not found", e);
        }
    }

    public List<EmployeeDTO> getEmployeesByLastNameAndCountry(String lastName, String country) {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                    .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "lastname and country not found", e);
        }
    }

    public List<EmployeeDTO> getEmployeesByFirstAndLastName(String firstName, String lastName) {
        try {
            return employeeRepository.findAll()
                    .stream()
                    .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                    .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                    .map(this::convertEmployeeEntityToEmployeeDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "firstname and lastname not found", e);
        }
    }

    private EmployeeDTO convertEmployeeEntityToEmployeeDTO(EmployeeEntity employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getId());
        employeeDTO.setTitle(employee.getTitle());
        employeeDTO.setfName(employee.getFirstName());
        employeeDTO.setlName(employee.getLastName());
        employeeDTO.setCompanyTitle(employee.getTitle());
        employeeDTO.setCity(employee.getCity());
        employeeDTO.setCountry(employee.getCountry());
        return employeeDTO;
    }
}
