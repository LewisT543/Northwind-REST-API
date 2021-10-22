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
    private OrderDetailIdEntity id;

    private BigDecimal unitPrice;

    private Integer quantity;

    private Double discount;

    @Column(name = "Discount", nullable = false)
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Column(name = "Quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 4)
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetailIdEntity getId() {
        return id;
    }

    public void setId(OrderDetailIdEntity id) {
        this.id = id;
    }
}