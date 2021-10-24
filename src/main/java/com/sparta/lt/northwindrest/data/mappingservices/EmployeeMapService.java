package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dto.EmployeeDTO;
import com.sparta.lt.northwindrest.entities.EmployeeEntity;
import com.sparta.lt.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeMapService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployeeDTO() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesById(Integer employeeId) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getId().equals(employeeId))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByFirstName(String firstName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByLastName(String lastName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByCountry(String country) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByFirstNameAndCountry(String firstName, String country) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByLastNameAndCountry(String lastName, String country) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                .filter(employeeEntity -> employeeEntity.getCountry().contains(country))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByFirstAndLastName(String firstName, String lastName) {
        return employeeRepository.findAll()
                .stream()
                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName))
                .filter(employeeEntity -> employeeEntity.getLastName().contains(lastName))
                .map(this::convertEmployeeEntityToEmployeeDTO)
                .collect(Collectors.toList());
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
