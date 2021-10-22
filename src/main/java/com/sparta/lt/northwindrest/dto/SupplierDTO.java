package com.sparta.lt.northwindrest.dto;

import com.sparta.lt.northwindrest.entities.SupplierEntity;

public class SupplierDTO {

    private int supplierID;
    private String companyName, contactName, contactTitle;
    private String address, city, region, postalCode, country;
    private String phone, fax;

    public SupplierDTO(SupplierEntity supplierEntity) {
        supplierID = supplierEntity.getId();
        companyName = supplierEntity.getCompanyName();
        contactName = supplierEntity.getContactName();
        contactTitle = supplierEntity.getContactTitle();
        address = supplierEntity.getAddress();
        city = supplierEntity.getCity();
        region = supplierEntity.getRegion();
        postalCode = supplierEntity.getPostalCode();
        country = supplierEntity.getCountry();
        phone = supplierEntity.getPhone();
        fax = supplierEntity.getFax();
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
