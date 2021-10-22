package com.sparta.lt.northwindrest.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "employeeterritories")
@Entity
public class EmployeeTerritoryEntity {
    @EmbeddedId
    private EmployeeTerritoryIdEntity id;

    public EmployeeTerritoryIdEntity getId() {
        return id;
    }

    public void setId(EmployeeTerritoryIdEntity id) {
        this.id = id;
    }
}