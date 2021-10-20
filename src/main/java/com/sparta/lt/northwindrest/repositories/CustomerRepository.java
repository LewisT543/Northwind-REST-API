package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}