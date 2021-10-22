package com.sparta.lt.northwindrest.dunno.repositories;

import com.sparta.lt.northwindrest.dunno.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer>, JpaSpecificationExecutor<ShipperEntity> {
}