package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dtos.OrderDTO;
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
                .map(this::convertOrderEntityToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByCustomer(String customerId) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getCustomerID().getId().equals(customerId))
                .map(this::convertOrderEntityToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByCountry(String country) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getShipCountry().contains(country))
                .map(this::convertOrderEntityToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByShippedDate(Instant shipDate) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getShippedDate().equals(shipDate))
                .map(this::convertOrderEntityToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByOrderDate(Instant orderDate) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getOrderDate().equals(orderDate))
                .map(this::convertOrderEntityToOrderDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByEmployeeId(Integer employeeId) {
        return orderRepository.findAll()
                .stream()
                .filter(orderEntity -> orderEntity.getEmployeeID().getId().equals(employeeId))
                .map(this::convertOrderEntityToOrderDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertOrderEntityToOrderDTO(OrderEntity order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerId(order.getCustomerID().getCompanyName());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setShipDate(order.getShippedDate());
        orderDTO.setEmployeeId(order.getEmployeeID().getId());
        orderDTO.setFreight(order.getFreight());
        orderDTO.setShipCompanyName(order.getShipName());
        orderDTO.setShipCountry(order.getShipCountry());
        return orderDTO;
    }
}
