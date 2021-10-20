package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}