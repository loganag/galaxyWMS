package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DeliveryNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long number;
    private Date date;
    @OneToMany(mappedBy = "deliveryNote", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeliveredItems> deliveredItems = new HashSet<>();

    public DeliveryNote() {
    }

    public DeliveryNote(Long number, Date date) {
        this.number = number;
        this.date = date;
    }

    public void addGoods(DeliveredItems goods){
        deliveredItems.add(goods);
        goods.setDeliveryNote(this);
    }

    public void removeGoods(DeliveredItems goods){
        deliveredItems.remove(goods);
        goods.setDeliveryNote(null);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<DeliveredItems> getDeliveredItems() {
        return deliveredItems;
    }

    public void setDeliveredItems(Set<DeliveredItems> deliveredItems) {
        this.deliveredItems = deliveredItems;
    }
}
