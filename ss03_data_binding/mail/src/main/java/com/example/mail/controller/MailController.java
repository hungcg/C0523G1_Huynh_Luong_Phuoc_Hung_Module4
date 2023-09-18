package com.example.mail.controller;

import com.example.mail.model.Mail;
import com.example.mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MailController {
    @Autowired
    private IMailService mailService;

    @GetMapping("")
    public String saveMail(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("pageSizeList", mailService.pageSizeList());
        model.addAttribute("languageList", mailService.languageList());
        return "setting";
    }

    @GetMapping("result")
    public String display(Model model) {
        model.addAttribute("mail", mailService.checkMail());
        return "/result";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes) {
        mailService.mailSetting(mail);
        redirectAttributes.addFlashAttribute("message", "save setting success");
        return "redirect:/";
    }
}
