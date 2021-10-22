package com.sparta.lt.northwindrest.dunno.repositories;

import com.sparta.lt.northwindrest.dunno.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer>, JpaSpecificationExecutor<SupplierEntity> {
}