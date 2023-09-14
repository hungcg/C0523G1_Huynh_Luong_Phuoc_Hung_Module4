package com.example.dictionary.controller;

import com.example.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @PostMapping("home")
    public String translate(@RequestParam String english, Model model) {
        for (Map.Entry<String, String> entry : dictionaryService.mapDictionary().entrySet()) {
            if (entry.getKey().toLowerCase().equals(english.toLowerCase())) {
                model.addAttribute("vietnamese",entry.getValue());
            } else
                model.addAttribute("message", "not found!!!");
        }
        return "home";
    }
}

