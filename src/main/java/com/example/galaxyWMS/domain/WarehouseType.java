package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class WarehouseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;

    @OneToMany(mappedBy = "warehouseType")
    private Set<Warehouse> items = new HashSet<>();

    public WarehouseType() {
    }

    public WarehouseType(String type, Set<Warehouse> items) {
        this.type = type;
        this.items = items;
    }

    public Set<Warehouse> getItems() {
        return items;
    }

    public void setItems(Set<Warehouse> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WarehouseType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
