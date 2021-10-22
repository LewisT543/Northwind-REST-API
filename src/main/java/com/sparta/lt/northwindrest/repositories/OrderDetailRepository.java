package com.sparta.lt.northwindrest.repositories;

import com.sparta.lt.northwindrest.entities.OrderDetailEntity;
import com.sparta.lt.northwindrest.entities.OrderDetailIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailIdEntity> {
}