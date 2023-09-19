package com.example.mail.repository;

import com.example.mail.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository {
    private static List<Mail> mailSettingList = new ArrayList<>();

    static {
        mailSettingList.add(new Mail(1, "English", 15, "King, Asgard", false));
        mailSettingList.add(new Mail(2, "Vietnamese", 10, "Xin chao, Viet Nam", true));
    }


    private static List<Integer> sizeList = new ArrayList<>();
    private static List<String> languageList = new ArrayList<>();

    static {
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
    public List<Mail> showAll() {
        return mailSettingList;
    }

    @Override
    public void mailSetting(Mail mail) {
        mailSettingList.set(mail.getId(), mail);
    }

    @Override
    public Mail findById(int id) {
        for (int i = 0; i < mailSettingList.size(); i++) {
            if (mailSettingList.get(i).getId() == id) {
                return mailSettingList.get(i);
            }
        }
        return null;
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
