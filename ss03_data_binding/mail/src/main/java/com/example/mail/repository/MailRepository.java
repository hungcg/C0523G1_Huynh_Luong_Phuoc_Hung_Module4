package com.example.mail.repository;

import com.example.mail.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository{
    private Mail email = new Mail ();

    private static List<Integer> sizeList = new ArrayList<>();
    private static List<String> languageList = new ArrayList<>();

    static{
        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
        sizeList.add(100);

        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }


    @Override
    public void mailSetting(Mail mail) {
        email = mail;
    }

    @Override
    public Mail checkMail() {
        return email;
    }

    @Override
    public List<Integer> pageSizeList() {
        return sizeList;
    }

    @Override
    public List<String> languageList() {
        return languageList;
    }


}
