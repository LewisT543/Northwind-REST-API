package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<RegionEntity, Integer> {
}