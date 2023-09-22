package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private IBlogService service;
    @GetMapping("")
    public String showBlog(@RequestParam(defaultValue = "0",required = false)int page,
                           @RequestParam(defaultValue = "",required = false) String title,
                           Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Blog> blogPage = service.findAllByTitleContaining(pageable,title);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("title",title);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String create (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        service.create(blog);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:";
    }
    @GetMapping("/showEdit")
    public String showEdit (@RequestParam int id, Model model){
        model.addAttribute("blog",service.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        service.edit(blog);
        redirectAttributes.addFlashAttribute("message","edit success");
        return "redirect:";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        service.delete(id);
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:";
    }
}
