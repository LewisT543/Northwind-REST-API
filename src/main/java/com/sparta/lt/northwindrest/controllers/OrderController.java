package com.sparta.lt.northwindrest.controllers;


import com.sparta.lt.northwindrest.entities.OrderEntity;
import com.sparta.lt.northwindrest.repositories.OrderRepository;
import com.sparta.lt.northwindrest.util.Util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<OrderEntity> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderByID(Integer orderID) {
        return orderRepository.findById(orderID);
    }

    public List<OrderEntity> getOrdersCustomerID(String customerID) {
        return orderRepository.findAll()
                .stream()
                .filter((o) -> o.getCustomerID().contains(customerID))
                .collect(Collectors.toList());
    }

    //TODO: Null handling
    public List<OrderEntity> getOrdersByCountryAndRegion(String country, String region) {
        if (country != null && region != null) {
            List<OrderEntity> results = new ArrayList<>();
            for (OrderEntity o : orderRepository.findAll()) {
                if (o.getShipCountry() != null && o.getShipRegion() != null) {
                    if (o.getShipCountry().contains(country) && o.getShipRegion().contains(region)) {
                        results.add(o);
                    }
                }
            }
            return results;
        } else if (region == null) {
            return orderRepository.findAll()
                    .stream()
                    .filter((o) -> o.getShipCountry().contains(country))
                    .collect(Collectors.toList());
        } else return null;
    }

    public List<OrderEntity> getOrdersByDate(String orderDate, String shippedDate) {
        if (orderDate != null && shippedDate != null) {
            List<OrderEntity> results = new ArrayList<>();
            for (OrderEntity o: orderRepository.findAll()) {
                if (o.getOrderDate() != null && o.getShippedDate() != null) {
                    if(o.getOrderDate().equals(Util.getDateAsInstant(orderDate))
                            && o.getShippedDate().equals(Util.getDateAsInstant(shippedDate))) {
                        results.add(o);
                    }
                }
            }
            return results;
        } else if (shippedDate == null) {
            return orderRepository.findAll()
                    .stream()
                    .filter((o) -> o.getOrderDate().equals(Util.getDateAsInstant(orderDate)))
                    .collect(Collectors.toList());
        } else return null;
    }
}
