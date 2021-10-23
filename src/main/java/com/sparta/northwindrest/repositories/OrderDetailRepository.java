package com.sparta.northwindrest.repositories;

import com.sparta.northwindrest.entities.OrderDetailEntity;
import com.sparta.northwindrest.entities.OrderDetailEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailEntityId> {
}