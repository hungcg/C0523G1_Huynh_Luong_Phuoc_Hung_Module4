package com.example.borrow_book.service;

import com.example.borrow_book.model.CodeRandom;
import com.example.borrow_book.repository.IRandomCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CodeRandomService implements ICodeRandomService {
    @Autowired
    private IRandomCodeRepository repository;

    private int randomNumber() {
        int number = (int) Math.round(Math.random() * 99999);
        return number;
    }

    @Override
    public String randomBorrowedNumber() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += randomNumber();
        }
        return result;
    }


    @Override
    public void create(CodeRandom codeRandom) {
        repository.save(codeRandom);
    }

    @Override
    public CodeRandom findByCodeRandom(String number) {
        return repository.findByCodeContaining(number);
    }

    @Override
    public void delete(CodeRandom codeRandom) {
        repository.delete(codeRandom);
    }
}
