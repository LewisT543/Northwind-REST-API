package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dto.OrderDetailDTO;
import com.sparta.lt.northwindrest.entities.OrderDetailEntity;
import com.sparta.lt.northwindrest.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailMapService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetailDTO> getAllOrderDetailDTO() {
        return orderDetailRepository.findAll()
                .stream()
                .map(this::convertOrderDetailEntityToOrderDetailDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDetailDTO> getOrderDetailById(Integer orderId) {
        return orderDetailRepository.findAll()
                .stream()
                .filter(orderDetailEntity -> orderDetailEntity.getId().getOrderID().equals(orderId))
                .map(this::convertOrderDetailEntityToOrderDetailDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDetailDTO> getOrderDetailByProduct(Integer productId) {
        return orderDetailRepository.findAll()
                .stream()
                .filter(orderDetailEntity -> orderDetailEntity.getId().getProductID().equals(productId))
                .map(this::convertOrderDetailEntityToOrderDetailDTO)
                .collect(Collectors.toList());
    }

    private OrderDetailDTO convertOrderDetailEntityToOrderDetailDTO(OrderDetailEntity orderDetails) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderId(orderDetails.getId().getOrderID());
        orderDetailDTO.setProductId(orderDetails.getId().getProductID());
        orderDetailDTO.setUnitPrice(orderDetails.getUnitPrice());
        orderDetailDTO.setQuantity(orderDetails.getQuantity());
        orderDetailDTO.setTotalValue(orderDetailDTO.getUnitPrice()
                .multiply(BigDecimal.valueOf(orderDetailDTO.getQuantity())));
        orderDetailDTO.setDiscount(orderDetails.getDiscount());
        orderDetailDTO.setDiscountedAmount(orderDetailDTO.getTotalValue()
                .multiply(BigDecimal.valueOf((1 - orderDetailDTO.getDiscount()) * 100)));
        return orderDetailDTO;
    }
}
