package com.sparta.lt.northwindrest.data.dto;

import java.math.BigDecimal;

public class OrderDetailDTO {
    private Integer orderId;
    private Integer productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal totalValue;
    private Double discount;
    private BigDecimal discountedAmount;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalValue() { return totalValue; }

    public void setTotalValue(BigDecimal totalValue) { this.totalValue = totalValue; }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(BigDecimal discountedAmount) {
        this.discountedAmount = discountedAmount;
    }
}
