package com.example.galaxyWMS.domain;

import jakarta.persistence.*;

@Entity
public class ReceivedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "Id")
    private Item item;
    private float amount;
    private float price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiptNote_id", referencedColumnName = "Id")
    private ReceiptNote receiptNote;

    public ReceivedItem() {
    }

    public ReceivedItem(Item item, float amount, float price, ReceiptNote receiptNote) {
        this.item = item;
        this.amount = amount;
        this.price = price;
        this.receiptNote = receiptNote;
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

    public ReceiptNote getReceiptNote() {
        return receiptNote;
    }

    public void setReceiptNote(ReceiptNote receiptNote) {
        this.receiptNote = receiptNote;
    }

    @Override
    public String toString() {
        return "ReceivedItem{" +
                "Id=" + Id +
                ", item=" + item +
                ", amount=" + amount +
                ", price=" + price +
                ", receiptNote=" + receiptNote +
                '}';
    }

}
