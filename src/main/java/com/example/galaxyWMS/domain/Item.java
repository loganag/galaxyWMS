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
    private Set<DeliveredItems> deliveredItems = new HashSet<>();
    @OneToMany(mappedBy = "item")
    private Set<ReceivedItems> receivedItems = new HashSet<>();

    public Item() {
    }

    public Item(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public void addDeliveredItem(DeliveredItems item){
        deliveredItems.add(item);
        item.setItem(this);
    }

    public void removeDeliveredItem(DeliveredItems item){
        deliveredItems.remove(item);
        item.setItem(this);
    }

    public void addReceivedItem(ReceivedItems item){
        receivedItems.add(item);
        item.setItem(this);
    }

    public void removeReceivedItem(ReceivedItems item){
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
}
