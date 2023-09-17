package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private float amount;
    @OneToMany(mappedBy = "item")
    private Set<DeliveredItem> deliveredItems = new HashSet<>();
    @OneToMany(mappedBy = "item")
    private Set<ReceivedItem> receivedItems = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    public Item() {
    }

    public Item(String name, float amount, Warehouse warehouse) {
        this.name = name;
        this.amount = amount;
        this.warehouse = warehouse;
    }

    public void addDeliveredItem(DeliveredItem item) {
        deliveredItems.add(item);
        item.setItem(this);
    }

    public void removeDeliveredItem(DeliveredItem item) {
        deliveredItems.remove(item);
        item.setItem(this);
    }

    public void addReceivedItem(ReceivedItem item) {
        receivedItems.add(item);
        item.setItem(this);
    }

    public void removeReceivedItem(ReceivedItem item) {
        receivedItems.remove(item);
        item.setItem(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float price) {
        this.amount = price;
    }

    public void increaseAmount(float amount) {
        this.amount += amount;
    }

    public void decreaseAmount(float amount) {
        this.amount -= amount;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
