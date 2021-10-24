package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dto.OrderDetailDTO;
import com.sparta.lt.northwindrest.data.mappingservices.OrderDetailMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailController {
    private final OrderDetailMapService orderDetailMapService;

    @Autowired
    public OrderDetailController(OrderDetailMapService orderDetailMapService) {
        this.orderDetailMapService = orderDetailMapService;
    }

    @GetMapping("northwind/orderdetails")
    public List<OrderDetailDTO> getAllOrderDetails(){
        return orderDetailMapService.getAllOrderDetailDTO();
    }

    @GetMapping(value="nothwind/orderdetails", params={"orderId"})
    public List<OrderDetailDTO> getOrderDetailsByOrderId(@RequestParam Integer orderId) {
        return orderDetailMapService.getOrderDetailById(orderId);
    }

    @GetMapping(value="northwind/orderdetails", params={"product"})
    public List<OrderDetailDTO> getOrderDetailsByProductId(@RequestParam Integer productId) {
        return orderDetailMapService.getOrderDetailByProduct(productId);
    }
}

