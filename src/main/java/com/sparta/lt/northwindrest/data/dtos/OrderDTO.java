package com.sparta.lt.northwindrest.data.dtos;

import com.sparta.lt.northwindrest.entities.OrderEntity;
import com.sparta.lt.northwindrest.util.Util;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderDTO {
    private String customerId;
    private Instant orderDate;
    private Instant shipDate;
    private int employeeId, orderID;
    private BigDecimal freight;
    private String shipCompanyName;
    private String shipCountry, shipRegion;

    public OrderDTO (OrderEntity orderEntity) {
        customerId = orderEntity.getCustomerID();
        orderDate = orderEntity.getOrderDate();
        shipDate = orderEntity.getShippedDate();
        employeeId = orderEntity.getEmployeeID();
        orderID = orderEntity.getId();
        freight = orderEntity.getFreight();
        shipRegion = orderEntity.getShipRegion();
        shipCompanyName = orderEntity.getShipName();
        shipCompanyName = orderEntity.getShipCountry();
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }
    public Instant getShipDate() {
        return shipDate;
    }

    public void setShipDate(Instant shipDate) {
        this.shipDate = shipDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getShipCompanyName() {
        return shipCompanyName;
    }

    public void setShipCompanyName(String shipCompanyName) {
        this.shipCompanyName = shipCompanyName;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }
}
