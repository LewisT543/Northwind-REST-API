package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.TerritoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<TerritoryEntity, String> {
}