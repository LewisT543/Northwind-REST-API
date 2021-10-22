package com.sparta.lt.northwindrest.entities;

import javax.persistence.*;

@Table(name = "territories")
@Entity
public class TerritoryEntity {
    @Id
    @Column(name = "TerritoryID", nullable = false, length = 20)
    private String id;

    @Column(name = "TerritoryDescription", nullable = false, length = 50)
    private String territoryDescription;

    @ManyToOne(optional = false)
    @JoinColumn(name = "RegionID", nullable = false)
    private RegionEntity regionID;

    public RegionEntity getRegionID() {
        return regionID;
    }

    public void setRegionID(RegionEntity regionID) {
        this.regionID = regionID;
    }

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