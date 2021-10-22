package com.sparta.lt.northwindrest.dunno.entities;

import javax.persistence.*;

@Table(name = "shippers")
@Entity
public class ShipperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipperID", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}