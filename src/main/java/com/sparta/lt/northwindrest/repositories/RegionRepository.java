package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<RegionEntity, Integer> {
}