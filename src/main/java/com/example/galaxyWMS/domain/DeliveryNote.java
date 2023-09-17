package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DeliveryNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long number;
    private LocalDate date;
    @OneToMany(mappedBy = "deliveryNote", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeliveredItem> deliveredItems = new HashSet<>();

    public DeliveryNote() {
    }

    public DeliveryNote(Long number, LocalDate date) {
        this.number = number;
        this.date = date;
    }

    public void addGoods(DeliveredItem goods) {
        deliveredItems.add(goods);
        goods.setDeliveryNote(this);
    }

    public void removeGoods(DeliveredItem goods) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<DeliveredItem> getDeliveredItems() {
        return deliveredItems;
    }

    public void setDeliveredItems(Set<DeliveredItem> deliveredItems) {
        this.deliveredItems = deliveredItems;
    }

    @Override
    public String toString() {
        return "DeliveryNote{" +
                "Id=" + Id +
                ", number=" + number +
                ", date=" + date +
                ", deliveredItems=" + deliveredItems +
                '}';
    }
}
