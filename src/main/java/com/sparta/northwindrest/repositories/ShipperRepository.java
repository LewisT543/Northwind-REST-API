package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer> {
}