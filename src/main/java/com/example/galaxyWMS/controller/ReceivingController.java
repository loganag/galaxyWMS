package com.example.galaxyWMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ReceivingController {
    @GetMapping("/receiving")
    public String receiving(Map<String, Object> model) {
        return "receiving";
    }

}
