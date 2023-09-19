package com.example.mail.service;

import com.example.mail.model.Mail;

import java.util.List;

public interface IMailService {
     public List<Mail> showAll();
     void mailSetting(Mail mail);
     public Mail findById(int id);

     List<Integer> pageSizeList();

     List<String> languageList();
}
