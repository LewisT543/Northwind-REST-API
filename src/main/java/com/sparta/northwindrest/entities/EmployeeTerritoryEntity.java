package com.sparta.northwindrest.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "employeeterritories")
@Entity
public class EmployeeTerritoryEntity {
    @EmbeddedId
    private EmployeeTerritoryEntityId id;

    public EmployeeTerritoryEntityId getId() {
        return id;
    }

    public void setId(EmployeeTerritoryEntityId id) {
        this.id = id;
    }
}