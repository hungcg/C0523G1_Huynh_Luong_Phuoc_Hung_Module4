package com.example.mail.repository;

import com.example.mail.model.Mail;

import java.util.List;

public interface IMailRepository {
    public List<Mail> showAll();
    void mailSetting(Mail mail);
    public Mail findById(int id);

    List<Integer> pageSizeList();

    List<String> languageList();
}
