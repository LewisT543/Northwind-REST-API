package com.sparta.lt.northwindrest.entities;

import com.sparta.lt.northwindrest.entities.RegionEntity;

import javax.persistence.*;

@Table(name = "territories")
@Entity
public class TerritoryEntity {
    @Id
    @Column(name = "TerritoryID", nullable = false, length = 20)
    private String id;

    private String territoryDescription;

    private RegionEntity regionID;

    @Access(AccessType.PROPERTY)
    @ManyToOne(optional = false)
    @JoinColumn(name = "RegionID", nullable = false)
    public RegionEntity getRegionID() {
        return regionID;
    }

    public void setRegionID(RegionEntity regionID) {
        this.regionID = regionID;
    }

    @Column(name = "TerritoryDescription", nullable = false, length = 50)
    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}