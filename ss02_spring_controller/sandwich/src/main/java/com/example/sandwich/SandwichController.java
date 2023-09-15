package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("result")
    public String showResult(){
        return "result";
    }
    @RequestMapping("save")
    public String chooseCondiment(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiment",condiment);
        return "result";

    }
}


