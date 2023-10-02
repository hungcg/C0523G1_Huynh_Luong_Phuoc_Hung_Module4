package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@SessionAttributes("cart")
@Controller
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("")
    public String showAll(Model model) {
        List<Product> productList = service.showAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/showDetail/{id}")
    public String showDetail(@PathVariable(name = "id", required = false)
                             int id, Model model) {
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @ModelAttribute("cart")
    public CartDto initCartDto() {
        return new CartDto();
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam int id, @SessionAttribute(value = "cart") CartDto cartDto, RedirectAttributes redirectAttributes) {
        Product product = service.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        } else {
            redirectAttributes.addFlashAttribute("message", "not found");
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete")
    public String deleteToCart(@RequestParam int id, @SessionAttribute(value = "cart") CartDto cartDto, RedirectAttributes redirectAttributes) {
        Product product = service.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.deleteProduct(productDto);
        } else {
            redirectAttributes.addFlashAttribute("message", "not found");
        }
        return "redirect:/cart";
    }

}

