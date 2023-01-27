package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ReceiptNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String number;
    private Date date;
    @OneToMany(mappedBy = "receiptNote", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReceivedItems> receivedItems = new HashSet<>();

    public ReceiptNote() {
    }

    public ReceiptNote(String number, Date date) {
        this.number = number;
        this.date = date;
    }

    public void addItems(ReceivedItems items){
        receivedItems.add(items);
        items.setReceiptNote(this);
    }

    public void removeItems(ReceivedItems items){
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<ReceivedItems> getReceivedItems() {
        return receivedItems;
    }

    public void setReceivedItems(Set<ReceivedItems> receivedGoods) {
        this.receivedItems = receivedGoods;
    }
}
