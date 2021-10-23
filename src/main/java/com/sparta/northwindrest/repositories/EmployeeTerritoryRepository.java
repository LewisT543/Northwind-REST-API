package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.EmployeeTerritoryEntity;
import com.sparta.northwindrest.entities.EmployeeTerritoryEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTerritoryRepository extends JpaRepository<EmployeeTerritoryEntity, EmployeeTerritoryEntityId> {
}