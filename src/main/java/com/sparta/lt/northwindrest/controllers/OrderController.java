package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dtos.OrderDTO;
import com.sparta.lt.northwindrest.data.mappingservices.OrderMapService;
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

    @GetMapping("/northwind/orders/{orderID}")
    public Optional<OrderEntity> getOrderByID(Integer orderID) {
        return orderRepository.findById(orderID);
    }

    @GetMapping("/northwind/orders/customer/{customerID}")
    public List<OrderEntity> getOrdersCustomerID(String customerID) {
        return orderRepository.findAll()
                .stream()
                .filter((o) -> o.getCustomerID().contains(customerID))
                .collect(Collectors.toList());
    }

    //TODO: Null handling
    @GetMapping("/northwind/orders/location")
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

    @GetMapping("/northwind/orders/date")
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
      
    @GetMapping(value="/northwind/orders", params={"employeeId"})
    public List<OrderDTO> getOrdersByEmployeeId(@RequestParam Integer employeeId) {
        return orderMapService.getOrdersByEmployeeId(employeeId);
    }
}
