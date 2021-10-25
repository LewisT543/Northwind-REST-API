package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}