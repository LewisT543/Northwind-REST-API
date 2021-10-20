package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer> {
}