package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

@Entity
public class DeliveredItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "Id")
    private Item item;
    private float amount;
    private float price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryNote_id", referencedColumnName = "Id")
    private DeliveryNote deliveryNote;

    public DeliveredItem() {
    }

    public DeliveredItem(Item item, float amount, float price, DeliveryNote deliveryNote) {
        this.item = item;
        this.amount = amount;
        this.price = price;
        this.deliveryNote = deliveryNote;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DeliveryNote getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(DeliveryNote deliveryNote) {
        this.deliveryNote = deliveryNote;
    }
}
