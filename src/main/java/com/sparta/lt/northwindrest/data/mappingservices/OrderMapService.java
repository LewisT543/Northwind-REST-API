package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dtos.OrderDTO;
import com.sparta.lt.northwindrest.entities.OrderEntity;
import com.sparta.lt.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private OrderDTO convertOrderEntityToOrderDTO(OrderEntity order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerId(order.getCustomerID());
        orderDTO.setOrderDate(String.valueOf(order.getOrderDate()));
        orderDTO.setEmployeeId(order.getEmployeeID());
        orderDTO.setFreight(order.getFreight());
        orderDTO.setShipCompanyName(order.getShipName());
        orderDTO.setShipCountry(order.getShipCountry());
        return orderDTO;
    }
}
