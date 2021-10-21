package com.sparta.lt.northwindrest.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "orders", indexes = {
        @Index(name = "ShippedDate", columnList = "ShippedDate"),
        @Index(name = "ShipPostalCode", columnList = "ShipPostalCode"),
        @Index(name = "OrderDate", columnList = "OrderDate")
})
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", nullable = false)
    private Integer id;

    private CustomerEntity customerID;

    private EmployeeEntity employeeID;

    private Instant orderDate;

    private Instant requiredDate;

    private Instant shippedDate;

    private ShipperEntity shipVia;

    private BigDecimal freight;

    private String shipName;

    private String shipAddress;

    private String shipCity;

    private String shipRegion;

    private String shipPostalCode;

    private String shipCountry;

    @Column(name = "ShipCountry", length = 15)
    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    @Column(name = "ShipPostalCode", length = 10)
    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    @Column(name = "ShipRegion", length = 15)
    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    @Column(name = "ShipCity", length = 15)
    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    @Column(name = "ShipAddress", length = 60)
    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    @Column(name = "ShipName", length = 40)
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    @Column(name = "Freight", precision = 10, scale = 4)
    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    @ManyToOne
    @JoinColumn(name = "ShipVia")
    public ShipperEntity getShipVia() {
        return shipVia;
    }

    public void setShipVia(ShipperEntity shipVia) {
        this.shipVia = shipVia;
    }

    @Column(name = "ShippedDate")
    public Instant getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Instant shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Column(name = "RequiredDate")
    public Instant getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Instant requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Column(name = "OrderDate")
    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    public EmployeeEntity getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(EmployeeEntity employeeID) {
        this.employeeID = employeeID;
    }

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    public CustomerEntity getCustomerID() {
        return customerID;
    }

    public void setCustomerID(CustomerEntity customerID) {
        this.customerID = customerID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}