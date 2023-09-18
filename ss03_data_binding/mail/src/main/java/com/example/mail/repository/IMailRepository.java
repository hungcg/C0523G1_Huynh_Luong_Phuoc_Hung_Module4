package com.example.mail.repository;

import com.example.mail.model.Mail;

import java.util.List;

public interface IMailRepository {
    void mailSetting(Mail mail);

    Mail checkMail();

    List<Integer> pageSizeList();

    List<String> languageList();


}
