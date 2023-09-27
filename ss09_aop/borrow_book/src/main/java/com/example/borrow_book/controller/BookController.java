package com.example.borrow_book.controller;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.CodeRandom;
import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.ICodeRandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService service;
    @Autowired
    private ICodeRandomService codeRandomService;

    @GetMapping("")
    public String showBook(Model model) {
        List<Book> bookList = service.showAll();
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping("/showFormBorrow")
    public String showFormBorrow(@RequestParam int id, Model model) {
        Book book = service.findById(id);
        if (book != null) {
            if (book.getCurrentQuantity() > 0) {
                model.addAttribute("book", book);
                return "borrow";
            } else {
                throw new NumberFormatException();
            }
        }
        return "index";
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        book.setCurrentQuantity(book.getCurrentQuantity() - 1);
        CodeRandom codeRandom = new CodeRandom(codeRandomService.randomBorrowedNumber(), book);
        codeRandomService.create(codeRandom);
        redirectAttributes.addFlashAttribute("message", "oh men, you borrow success this book");
        service.save(book);
        return "redirect:/";
    }
}
