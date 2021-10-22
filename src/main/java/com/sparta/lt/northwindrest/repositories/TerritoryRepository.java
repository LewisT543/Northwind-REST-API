package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.TerritoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<TerritoryEntity, String> {
}