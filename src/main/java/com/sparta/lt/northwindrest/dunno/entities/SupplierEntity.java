package com.sparta.lt.northwindrest.dunno.entities;

import javax.persistence.*;

@Table(name = "suppliers")
@Entity
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}