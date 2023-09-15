package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
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
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String displayTranslate() {
        return "display";
    }

    @PostMapping("translate")
    public String translateWord(@RequestParam String english, Model model) {
        model.addAttribute("english", english);
        for (Map.Entry<String, String> entry : dictionaryService.mapDictionary().entrySet()) {
            if (entry.getKey().toLowerCase().equals(english.toLowerCase())) {
                model.addAttribute("vietnamese", entry.getValue());
            } else {
                model.addAttribute("message", "not found!!!");
            }
        }
        return "display";
    }
}

