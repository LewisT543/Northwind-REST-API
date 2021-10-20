package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
}