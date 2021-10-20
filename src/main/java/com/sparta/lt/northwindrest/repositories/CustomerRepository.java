package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomersEntity, String> {
}