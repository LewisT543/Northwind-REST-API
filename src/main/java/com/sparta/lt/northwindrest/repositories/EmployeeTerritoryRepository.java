package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.EmployeeTerritoryEntity;
import com.sparta.lt.northwindrest.entities.EmployeeTerritoryIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTerritoryRepository extends JpaRepository<EmployeeTerritoryEntity, EmployeeTerritoryIdEntity> {
}