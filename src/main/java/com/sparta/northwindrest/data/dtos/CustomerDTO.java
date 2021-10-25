package com.sparta.northwindrest.data.dtos;

import com.sparta.northwindrest.entities.CustomerEntity;

import com.sparta.lt.northwindrest.entities.CustomerEntity;

public class CustomerDTO {
    private String contactName;
    private String companyName;
    private String contactTitle;
    private String city, region;
    private String country;
    private String id;

    public CustomerDTO(CustomerEntity customerEntity) {
        contactName = customerEntity.getContactName();
        companyName = customerEntity.getCompanyName();
        contactTitle = customerEntity.getContactTitle();
        city = customerEntity.getCity();
        id = customerEntity.getId();
        region = customerEntity.getRegion();
        country = customerEntity.getCountry();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}