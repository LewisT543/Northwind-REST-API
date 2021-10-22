package com.sparta.lt.northwindrest.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailIdEntity implements Serializable {
    private static final long serialVersionUID = 165338009634730528L;
    @Column(name = "OrderID", nullable = false)
    private Integer orderID;
    @Column(name = "ProductID", nullable = false)
    private Integer productID;

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, orderID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetailIdEntity entity = (OrderDetailIdEntity) o;
        return Objects.equals(this.productID, entity.productID) &&
                Objects.equals(this.orderID, entity.orderID);
    }
}