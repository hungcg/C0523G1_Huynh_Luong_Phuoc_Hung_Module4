package com.example.mail.service;

import com.example.mail.model.Mail;
import com.example.mail.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService {
    @Autowired
    private IMailRepository mailRepository;

    @Override
    public List<Mail> showAll() {
        return mailRepository.showAll();
    }

    @Override
    public void mailSetting(Mail mail) {
        mailRepository.mailSetting(mail);

    }

    @Override
    public Mail findById(int id) {
        return mailRepository.findById(id);
    }

    @Override
    public List<Integer> pageSizeList() {
        return mailRepository.pageSizeList();
    }

    @Override
    public List<String> languageList() {
        return mailRepository.languageList();
    }
}
