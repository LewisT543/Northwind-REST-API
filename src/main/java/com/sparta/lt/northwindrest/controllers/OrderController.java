package com.sparta.lt.northwindrest.controllers;


import com.sparta.lt.northwindrest.entities.OrderEntity;
import com.sparta.lt.northwindrest.repositories.OrderRepository;
import com.sparta.lt.northwindrest.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<OrderEntity> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("orders/{orderID}")
    public Optional<OrderEntity> getOrderByID(Integer orderID) {
        return orderRepository.findById(orderID);
    }

    @GetMapping("orders/customer/{customerID}")
    public List<OrderEntity> getOrdersCustomerID(String customerID) {
        return orderRepository.findAll()
                .stream()
                .filter((o) -> o.getCustomerID().equals(customerID))
                .collect(Collectors.toList());
    }

    //TODO: Null handling
    @GetMapping("orders/location")
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

    @GetMapping("orders/date")
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
