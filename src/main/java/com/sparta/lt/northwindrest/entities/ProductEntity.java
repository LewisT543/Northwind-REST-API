package com.sparta.lt.northwindrest.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "products", indexes = {
        @Index(name = "ProductName", columnList = "ProductName")
})
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private Integer id;

    private String productName;

    private SupplierEntity supplierID;

    private CategoryEntity categoryID;

    private String quantityPerUnit;

    private BigDecimal unitPrice;

    private Integer unitsInStock;

    private Integer unitsOnOrder;

    private Integer reorderLevel;

    private Boolean discontinued = false;

    @Column(name = "Discontinued", nullable = false)
    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Column(name = "ReorderLevel")
    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @Column(name = "UnitsOnOrder")
    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    @Column(name = "UnitsInStock")
    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Column(name = "UnitPrice", precision = 10, scale = 4)
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "QuantityPerUnit", length = 20)
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    public CategoryEntity getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryEntity categoryID) {
        this.categoryID = categoryID;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    public SupplierEntity getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(SupplierEntity supplierID) {
        this.supplierID = supplierID;
    }

    @Column(name = "ProductName", nullable = false, length = 40)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}