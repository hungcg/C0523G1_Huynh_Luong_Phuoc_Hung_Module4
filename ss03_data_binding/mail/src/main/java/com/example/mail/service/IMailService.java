package com.example.mail.service;

import com.example.mail.model.Mail;

import java.util.List;

public interface IMailService {
     void mailSetting (Mail mail);
     Mail checkMail();
     List<Integer> pageSizeList();

     List<String> languageList();
}
