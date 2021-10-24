package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dto.OrderDTO;
import com.sparta.lt.northwindrest.entities.OrderEntity;
import com.sparta.lt.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrderDTO() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertOrderEntityToBasicOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByCustomer(String customerId) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getCustomerID().getId().equals(customerId))
                .map(this::convertOrderEntityToBasicOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByCountry(String country) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getShipCountry().contains(country))
                .map(this::convertOrderEntityToBasicOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByShippedDate(Instant shipDate) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getShippedDate().equals(shipDate))
                .map(this::convertOrderEntityToBasicOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByOrderDate(Instant orderDate) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getOrderDate().equals(orderDate))
                .map(this::convertOrderEntityToBasicOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByEmployeeId(Integer employeeId) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getEmployeeID().getId().equals(employeeId))
                .map(this::convertOrderEntityToBasicOrderDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertOrderEntityToBasicOrderDTO(OrderEntity order) {
        OrderDTO orderDTOBasic = new OrderDTO();
        orderDTOBasic.setOrderId(order.getId());
        orderDTOBasic.setCustomerName(order.getCustomerID().getCompanyName());
        orderDTOBasic.setOrderDate(order.getOrderDate());
        orderDTOBasic.setShipDate(order.getShippedDate());
        orderDTOBasic.setEmployee(order.getEmployeeID().getFirstName() + " " + order.getEmployeeID().getLastName());
        orderDTOBasic.setFreight(order.getFreight());
        orderDTOBasic.setShipCompanyName(order.getShipVia().getCompanyName());
        orderDTOBasic.setShipCountry(order.getShipCountry());
        return orderDTOBasic;
    }
}
