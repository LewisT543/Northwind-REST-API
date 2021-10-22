package com.sparta.lt.northwindrest.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "`order details`")
@Entity
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailEntityId id;

    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Discount", nullable = false)
    private Double discount;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetailEntityId getId() {
        return id;
    }

    public void setId(OrderDetailEntityId id) {
        this.id = id;
    }
}