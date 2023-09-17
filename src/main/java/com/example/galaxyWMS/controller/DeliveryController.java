package com.example.galaxyWMS.controller;

import com.example.galaxyWMS.domain.DeliveredItem;
import com.example.galaxyWMS.domain.DeliveryNote;
import com.example.galaxyWMS.domain.Item;
import com.example.galaxyWMS.dto.ItemDeliveryDto;
import com.example.galaxyWMS.repos.DeliveredItemsepo;
import com.example.galaxyWMS.repos.DeliveryNoteRepo;
import com.example.galaxyWMS.repos.ItemRepo;
import com.example.galaxyWMS.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class DeliveryController {
    private final ItemRepo itemRepo;
    private final ItemService itemService;

    private final DeliveryNoteRepo deliveryNoteRepo;
    private final DeliveredItemsepo deliveredItemsepo;

    public DeliveryController(ItemRepo itemRepo, DeliveryNoteRepo deliveryNoteRepo, DeliveredItemsepo deliveredItemsepo, ItemService itemService) {
        this.itemRepo = itemRepo;
        this.deliveryNoteRepo = deliveryNoteRepo;
        this.deliveredItemsepo = deliveredItemsepo;
        this.itemService = itemService;
    }

    @GetMapping("/delivery")
    public String index(Model model) {
        List<Item> itemList = itemRepo.findAll();
        model.addAttribute("itemList", itemList);
        model.addAttribute("itemDto", new ItemDeliveryDto());
        return "delivery";
    }

    @PostMapping("/delivery")
    public String createNote(ItemDeliveryDto itemDeliveryDto,
                             @RequestParam Long noteNumber,
                             @RequestParam LocalDate noteDate,
                             @RequestParam String price,
                             @RequestParam String amount) {
        System.out.println(itemDeliveryDto);
        List<Item> nonNullItems = itemDeliveryDto.getItemList().stream().filter(item -> item != null).toList();
        nonNullItems.forEach(item -> System.out.println(item.getId()));
        nonNullItems.forEach(item -> System.out.println(item.getName()));
        System.out.println(price);
        System.out.println(amount);

        String[] prices = price.split(",");
        prices = Arrays.stream(prices)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        String[] amounts = amount.split(",");
        amounts = Arrays.stream(amounts)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        DeliveryNote deliveryNote = new DeliveryNote(noteNumber, noteDate);
        deliveryNoteRepo.save(deliveryNote);

        for (int i = 0; i < nonNullItems.size(); i++) {
            deliveredItemsepo.save(
                    new DeliveredItem(
                            nonNullItems.get(i),
                            Float.parseFloat(amounts[i]),
                            Float.parseFloat(prices[i]),
                            deliveryNote)
            );
            itemService.deleteItemOrDecreaseAmount(nonNullItems.get(i), Float.parseFloat(amounts[i]));
        }
        return "redirect:/";
    }
}
