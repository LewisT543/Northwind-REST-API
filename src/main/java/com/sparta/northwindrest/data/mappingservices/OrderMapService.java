package com.sparta.northwindrest.data.mappingservices;

import com.sparta.northwindrest.data.dtos.OrderDTO;
import com.sparta.northwindrest.entities.OrderEntity;
import com.sparta.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrderDTO() {
        try {
            return orderRepository.findAll()
                    .stream()
                    .map(this::convertOrderEntityToOrderDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }
    }

    public List<OrderDTO> getOrdersByCustomer(String customerId) {
        try {
            return orderRepository.findAll()
                    .stream()
                    .filter(orderEntity -> orderEntity.getCustomerID().getId().equals(customerId))
                    .map(this::convertOrderEntityToOrderDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer id not found", e);
        }
    }

    public List<OrderDTO> getOrdersByCountry(String country) {
        try {
            return orderRepository.findAll()
                    .stream()
                    .filter(orderEntity -> orderEntity.getShipCountry().contains(country))
                    .map(this::convertOrderEntityToOrderDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "country not found", e);
        }
    }

    public List<OrderDTO> getOrdersByShippedDate(Instant shipDate) {
        try {
            return orderRepository.findAll()
                    .stream()
                    .filter(orderEntity -> orderEntity.getShippedDate().equals(shipDate))
                    .map(this::convertOrderEntityToOrderDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ship dates not found", e);
        }
    }

    public List<OrderDTO> getOrdersByOrderDate(Instant orderDate) {
        try {
            return orderRepository.findAll()
                    .stream()
                    .filter(orderEntity -> orderEntity.getOrderDate().equals(orderDate))
                    .map(this::convertOrderEntityToOrderDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "order date not found", e);
        }
    }

    public List<OrderDTO> getOrdersByEmployeeId(Integer employeeId) {
        try {
            return orderRepository.findAll()
                    .stream()
                    .filter(orderEntity -> orderEntity.getEmployeeID().getId().equals(employeeId))
                    .map(this::convertOrderEntityToOrderDTO)
                    .collect(Collectors.toList());
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee id not found", e);
        }
    }

    private OrderDTO convertOrderEntityToOrderDTO(OrderEntity order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getId());
        orderDTO.setCustomerName(order.getCustomerID().getCompanyName());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setShipDate(order.getShippedDate());
        orderDTO.setEmployee(order.getEmployeeID().getFirstName() + " " + order.getEmployeeID().getLastName());
        orderDTO.setFreight(order.getFreight());
        orderDTO.setShipCompanyName(order.getShipVia().getCompanyName());
        orderDTO.setShipCountry(order.getShipCountry());
        return orderDTO;
    }
}
