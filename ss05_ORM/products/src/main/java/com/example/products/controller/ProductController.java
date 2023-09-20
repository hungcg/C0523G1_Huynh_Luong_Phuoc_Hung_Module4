package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RequestMapping("/product")
@Controller
public class ProductController {
    @Autowired
    private IProductService service;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("productList",service.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create (@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        service.add(product);
        redirectAttributes.addFlashAttribute("message","add success");
        return "redirect:/product";
    }
    @GetMapping("/{id}/formUpdate")
    public String formUpdate (@PathVariable int id, Model model){
        model.addAttribute("product",service.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        service.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message", "update success");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public  String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        service.delete(id);
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:/product";
    }
    @GetMapping("/{id}/formDetail")
    public String formDetail(@PathVariable int id, Model model){
        model.addAttribute("productList",service.findById(id));
        return "detail";
    }
}
