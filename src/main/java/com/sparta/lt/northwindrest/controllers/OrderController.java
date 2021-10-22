package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.OrderDTO;
import com.sparta.lt.northwindrest.data.mappingservices.OrderMapService;
import com.sparta.lt.northwindrest.entities.OrderEntity;
import com.sparta.lt.northwindrest.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderMapService orderMapService;

    @GetMapping("/northwind/orders")
    public List<OrderDTO> getAllOrders() {
        return orderMapService.getAllOrderDTO();
    }

    @GetMapping(value="/northwind/orders", params={"customerId"})
    public List<OrderDTO> getOrdersByCustomer(@RequestParam String customerId) {
        return orderMapService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/northwind/orders/{orderID}")
    public List<OrderDTO> getOrderByID(@PathVariable Optional<Integer> orderID) {
        List<OrderDTO> orders = new ArrayList<>();
        if (orderID.isPresent()) {
            for (OrderDTO o : orderMapService.getAllOrderDTO()) {
                if (o.getOrderID() == orderID.get()) {
                    orders.add(o);
                    break;
                }
            }
        }
        return orders;
    }

    @GetMapping("/northwind/orders/customer/{customerID}")
    public List<OrderDTO> getOrdersCustomerID(Optional<String> customerID) {
        List<OrderDTO> orders = new ArrayList<>();
        if (customerID.isPresent()) {
            for (OrderDTO o : orderMapService.getAllOrderDTO()) {
                if (o.getCustomerId().equals(customerID.get())) {
                    orders.add(o);
                    break;
                }
            }
        }
        return orders;
    }

    //TODO: Null handling
    @GetMapping("/northwind/orders/location")
    public List<OrderDTO> getOrdersByCountryAndRegion(String country, String region) {
        List<OrderDTO> results = new ArrayList<>();

        if (country != null && region != null) {
            for (OrderDTO o : orderMapService.getAllOrderDTO()) {
                if (o.getShipCountry() != null && o.getShipRegion() != null) {
                    if (o.getShipCountry().contains(country) && o.getShipRegion().contains(region)) {
                        results.add(o);
                    }
                }
            }
        } else if (region == null) {
            for (OrderDTO o : orderMapService.getAllOrderDTO()) {
                if (o.getShipCountry() != null && o.getShipCountry().contains(country)) {
                    results.add(o);
                }
            }
        }
        return results;
    }

    @GetMapping("/northwind/orders/date")
    public List<OrderDTO> getOrdersByDate(String orderDate, String shippedDate) {
        List<OrderDTO> results = new ArrayList<>();

        if (orderDate != null && shippedDate != null) {
            for (OrderDTO o : orderMapService.getAllOrderDTO()) {
                if (o.getOrderDate() != null && o.getShipDate() != null) {
                    if (o.getOrderDate().equals(Util.getDateAsInstant(orderDate))
                            && o.getShipDate().equals(Util.getDateAsInstant(shippedDate))) {
                        results.add(o);
                    }
                }
            }
        } else if (shippedDate == null) {
            for (OrderDTO o : orderMapService.getAllOrderDTO()) {
                if (o.getOrderDate() != null && o.getOrderDate().equals(orderDate)) {
                    results.add(o);
                }
            }
        }
        return results;
    }
      
    @GetMapping(value="/northwind/orders", params={"employeeId"})
    public List<OrderDTO> getOrdersByEmployeeId(@RequestParam Integer employeeId) {
        return orderMapService.getOrdersByEmployeeId(employeeId);
    }
}
