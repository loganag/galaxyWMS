package com.example.galaxyWMS.controller;

import com.example.galaxyWMS.domain.Item;
import com.example.galaxyWMS.domain.Warehouse;
import com.example.galaxyWMS.repos.ItemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    private final ItemRepo itemRepo;

    public MainController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Item> items;
        items = itemRepo.findAll();
        model.addAttribute("items", items);

        return "main";
    }

    @PostMapping("/")
    public String add(@RequestParam String name, @RequestParam Float price, Map<String, Object> model) {
        Item item = new Item(name, price, new Warehouse());
        itemRepo.save(item);

        Iterable<Item> items = itemRepo.findAll();
        model.put("items", items);
        return "main";
    }

    @PostMapping("/itemDelete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        itemRepo.deleteById(id);
        return "redirect:/";
    }

}