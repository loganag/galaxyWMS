package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ReceiptNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String number;

    private LocalDate date;
    @OneToMany(mappedBy = "receiptNote", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReceivedItem> receivedItems = new HashSet<>();

    public ReceiptNote() {
    }

    public ReceiptNote(String number, LocalDate date) {
        this.number = number;
        this.date = date;
    }

    public void addItems(ReceivedItem items) {
        receivedItems.add(items);
        items.setReceiptNote(this);
    }

    public void removeItems(ReceivedItem items) {
        receivedItems.remove(items);
        items.setReceiptNote(null);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<ReceivedItem> getReceivedItems() {
        return receivedItems;
    }

    public void setReceivedItems(Set<ReceivedItem> receivedGoods) {
        this.receivedItems = receivedGoods;
    }

    @Override
    public String toString() {
        return "ReceiptNote{" +
                "Id=" + Id +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", receivedItems=" + receivedItems +
                '}';
    }
}
