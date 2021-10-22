package com.sparta.lt.northwindrest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "region")
@Entity
public class RegionEntity {
    @Id
    @Column(name = "RegionID", nullable = false)
    private Integer id;

    private String regionDescription;

    @Column(name = "RegionDescription", nullable = false, length = 50)
    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}