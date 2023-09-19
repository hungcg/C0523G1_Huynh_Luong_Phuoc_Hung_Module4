package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String showList (Model model){
        model.addAttribute("productList",productService.findAll());
        return "list";
    }
    @GetMapping("/product/showCreate")
    public String showCreate (Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("product/create")
    public String create (@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.create(product);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/showEdit")
    public String showEdit (@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping ("product/edit")
    public String edit (@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.edit(product.getId(), product);
        redirectAttributes.addFlashAttribute("message","edit success");
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/delete")
    public String delete (@PathVariable Integer id, RedirectAttributes redirectAttributes){
       productService.delete(id);
       redirectAttributes.addFlashAttribute("message", "delete success");
       return "redirect:/product";
    }
    @GetMapping("product/{id}/showDetail")
    public String showDetail (@PathVariable Integer id,Model model){
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }
}
