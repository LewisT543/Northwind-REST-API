package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.entities.CustomerEntity;
import com.sparta.lt.northwindrest.entities.OrderEntity;
import com.sparta.lt.northwindrest.entities.ProductEntity;
import com.sparta.lt.northwindrest.repositories.CustomerRepository;
import com.sparta.lt.northwindrest.repositories.OrderRepository;
import com.sparta.lt.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class NorthwindController {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public NorthwindController(CustomerRepository customerRepository, ProductRepository productRepository,
                               OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getCustomers(@RequestParam(required = false) String name) {
        if (name == null) {
            return customerRepository.findAll();
        }
        return customerRepository.findAll()
                .stream()
                .filter(customerEntity -> customerEntity.getContactName().contains(name))
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }


    //<-------- Orders Mapping starts here ------->
    @GetMapping("/orders")
    public List<OrderEntity> getOrders() {
        return new OrderController(orderRepository).getOrders();
    }

    @GetMapping("orders/{orderID}")
    public Optional<OrderEntity> getOrderByID(@PathVariable Integer orderID) {
        return new OrderController(orderRepository).getOrderByID(orderID);
    }

    @GetMapping("orders/customer/{customerID}")
    public List<OrderEntity> getOrdersByCustomerID(@PathVariable String customerID) {
        return new OrderController(orderRepository).getOrdersCustomerID(customerID);
    }

    @GetMapping("orders/location")
    public List<OrderEntity> getOrdersByRegionAndCountry(
            @RequestParam String country, @RequestParam(required = false) String region) {
        return new OrderController(orderRepository).getOrdersByCountryAndRegion(country, region);
    }

    @GetMapping("orders/date")
    public List<OrderEntity> getOrdersByOrderDateAndShippedDate(
            @RequestParam String orderDate, @RequestParam(required = false) String shippedDate) {
        return new OrderController(orderRepository).getOrdersByDate(orderDate, shippedDate);

    }
}
