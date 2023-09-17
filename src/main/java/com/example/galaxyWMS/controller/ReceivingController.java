package com.example.galaxyWMS.controller;

import com.example.galaxyWMS.domain.Item;
import com.example.galaxyWMS.domain.ReceiptNote;
import com.example.galaxyWMS.domain.ReceivedItem;
import com.example.galaxyWMS.domain.Warehouse;
import com.example.galaxyWMS.repos.ItemRepo;
import com.example.galaxyWMS.repos.ReceiptNoteRepo;
import com.example.galaxyWMS.repos.ReceivedItemRepo;
import com.example.galaxyWMS.repos.WarehouseRepo;
import com.example.galaxyWMS.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ReceivingController {
    private final ItemRepo itemRepo;
    private final ItemService itemService;

    private final ReceivedItemRepo receivedItemRepo;

    private final ReceiptNoteRepo receiptNoteRepo;

    private final WarehouseRepo warehouseRepo;


    public ReceivingController(ItemRepo itemRepo, ItemService itemService, ReceivedItemRepo receivedItemRepo, ReceiptNoteRepo receiptNoteRepo, WarehouseRepo warehouseRepo) {
        this.itemRepo = itemRepo;

        this.itemService = itemService;
        this.receivedItemRepo = receivedItemRepo;
        this.receiptNoteRepo = receiptNoteRepo;
        this.warehouseRepo = warehouseRepo;
    }

    @GetMapping(value = "/receiving")
    public String index(Model model) {
        Iterable<Warehouse> warehouses = warehouseRepo.findAll();
        model.addAttribute("warehouses", warehouses);
        return "receiving";
    }

    @PostMapping("/itemCreate")
    public String addNewItem(@ModelAttribute("item") Item newItem, Model model) {
        System.out.println(newItem);

        return "redirect:receiving";
    }

    @PostMapping("/receiving")
    public String createReceiptNote(@RequestParam String itemName,
                                    @RequestParam String itemAmount,
                                    @RequestParam String itemPrice,
                                    @RequestParam String noteNumber,
                                    @RequestParam LocalDate noteDate,
                                    @RequestParam String warehouse) {
        ReceiptNote receiptNote;
        if (receiptNoteRepo.findByNumber(noteNumber) != null) {
            receiptNote = receiptNoteRepo.findByNumber(noteNumber);
        } else {
            receiptNote = new ReceiptNote(noteNumber, noteDate);
            receiptNoteRepo.save(receiptNote);
        }
        Item itemToSave = new Item(itemName, Float.parseFloat(itemAmount), warehouseRepo.findByName(warehouse));
        itemService.addItemOrIncreaseAmount(itemToSave);

        itemToSave = itemRepo.findFirstByName(itemName);
        receivedItemRepo.save(new ReceivedItem(itemToSave, Float.parseFloat(itemAmount), Float.parseFloat(itemPrice), receiptNote));

        return "receiving";
    }
}
