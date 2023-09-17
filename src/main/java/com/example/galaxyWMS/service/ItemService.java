package com.example.galaxyWMS.service;

import com.example.galaxyWMS.domain.Item;
import com.example.galaxyWMS.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    public void addItemOrIncreaseAmount(Item item) {
        ArrayList<Item> itemsFromRepo = (ArrayList<Item>) itemRepo.findByName(item.getName());
        if (!itemsFromRepo.isEmpty()) {
            if (itemsFromRepo.size() > 1) {
                System.out.println("There are more than 1 item with name " + item.getName());
            }
            Item item1 = itemsFromRepo.get(0);
            item1.increaseAmount(item.getAmount());
            itemRepo.save(item1);
        } else {
            itemRepo.save(item);
        }
    }

    public void deleteItemOrDecreaseAmount(Item item, float amount) {
        System.out.println("item amount " + item.getAmount());

        ArrayList<Item> itemsFromRepo = (ArrayList<Item>) itemRepo.findByName(item.getName());
        if (!itemsFromRepo.isEmpty()) {
            if (itemsFromRepo.size() > 1) {
                System.out.println("There are more than 1 item with name " + item.getName());
            }
            Item item1 = itemsFromRepo.get(0);
            if (item1.getAmount() == amount) {
                System.out.println("item1 amount " + item1.getAmount());
                itemRepo.delete(item1);
            } else {
                item1.decreaseAmount(amount);
                itemRepo.save(item1);
            }
        } else {
            System.out.println("There is no item with name " + item.getName());
        }
    }
}
