package com.sparta.northwindrest.data.dtos;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderDTO {
    private Integer orderId;
    private String customerName;
    private Instant orderDate;
    private Instant shipDate;
    private String employeeName;
    private BigDecimal freight;
    private String shipCompanyName;
    private String shipCountry;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getEmployee() {
        return employeeName;
    }

    public void setEmployee(String employee) {
        this.employeeName = employee;
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
