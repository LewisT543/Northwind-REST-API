package com.sparta.lt.northwindrest.dto;

import com.sparta.lt.northwindrest.entities.ShipperEntity;

public class ShipperDTO {

    private String company;
    private String phone;

    public ShipperDTO(ShipperEntity shipper) {
        this.company = shipper.getCompanyName();;
        this.phone = shipper.getPhone();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
