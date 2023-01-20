package com.example.galaxyWMS.controller;

import com.example.galaxyWMS.domain.Goods;
import com.example.galaxyWMS.repos.GoogsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private GoogsRepo googsRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Goods> goods = googsRepo.findAll();
        model.put("goods", goods);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam Float price, Map<String, Object> model){
        Goods good = new Goods(name, price);
        googsRepo.save(good);

        Iterable<Goods> goods = googsRepo.findAll();
        model.put("goods", goods);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Goods> goods;
        if(filter != null && !filter.isEmpty()) {
            goods = googsRepo.findByName(filter);
        }
        else {
            goods = googsRepo.findAll();
        }
        model.put("goods", goods);
        return "main";
    }

}