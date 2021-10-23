package com.sparta.northwindrest.data.dtos;

import com.sparta.northwindrest.entities.ShipperEntity;


public class ShipperDTO {
    private Integer shipperID;
    private String companyName, phone;

    public ShipperDTO(ShipperEntity shipperEntity) {
        shipperID = shipperEntity.getId();
        companyName = shipperEntity.getCompanyName();
        phone = shipperEntity.getPhone();
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
