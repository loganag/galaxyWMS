package com.example.galaxyWMS.dto;

import com.example.galaxyWMS.domain.Item;

import java.util.List;

public class ItemDeliveryDto {
    private List<Item> itemList;

    public ItemDeliveryDto() {
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "ItemDeliveryDto{" +
                "itemList=" + itemList +
                '}';
    }
}
