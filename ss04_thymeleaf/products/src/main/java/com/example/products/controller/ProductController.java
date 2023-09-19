package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String list (Model model){
        model.addAttribute("productList",productService.findAll());
        return "list";
    }

}
