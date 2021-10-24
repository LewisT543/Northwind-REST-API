package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dto.OrderDTO;
import com.sparta.lt.northwindrest.data.mappingservices.OrderMapService;
import com.sparta.lt.northwindrest.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class OrderController {
    private final OrderMapService orderMapService;
    @Autowired
    public OrderController(OrderMapService orderMapService) {
        this.orderMapService = orderMapService;
    }

    @GetMapping("/northwind/orders")
    public List<OrderDTO> getAllOrders() {
        return orderMapService.getAllOrderDTO();
    }

    @GetMapping(value="/northwind/orders", params={"customerId"})
    public List<OrderDTO> getOrdersByCustomer(@RequestParam String customerId) {
        return orderMapService.getOrdersByCustomer(customerId);
    }

    @GetMapping(value="/northwind/orders", params={"country"})
    public List<OrderDTO> getOrdersByCountry(@RequestParam String country) {
        return orderMapService.getOrdersByCountry(country);
    }

    // This is broken -> Must allow for inputs of format (dd-MM-YYYY)
    @GetMapping(value="/northwind/orders", params={"shippedDate"})
    public List<OrderDTO> getOrdersByShippedDate(@RequestParam String shipDate) {
        Instant shipDateInstant = Util.getDateAsInstant(shipDate);
        return orderMapService.getOrdersByShippedDate(shipDateInstant);
    }

    // This is broken -> Must allow for inputs of format (dd-MM-YYYY)
    @GetMapping(value="/northwind/orders", params={"orderDate"})
    public List<OrderDTO> getOrdersByOrderDate(@RequestParam String orderDate) {
        Instant orderDateInstant = Util.getDateAsInstant(orderDate);
        return orderMapService.getOrdersByOrderDate(orderDateInstant);
    }

    @GetMapping(value="/northwind/orders", params={"employeeId"})
    public List<OrderDTO> getOrdersByEmployeeId(@RequestParam Integer employeeId) {
        return orderMapService.getOrdersByEmployeeId(employeeId);
    }
}
