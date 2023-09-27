package com.example.borrow_book.service;

import com.example.borrow_book.model.CodeRandom;

import java.util.List;

public interface ICodeRandomService {
    String randomBorrowedNumber();

    void create(CodeRandom codeRandom);

    CodeRandom findByCodeRandom(String number);

    void delete(CodeRandom codeRandom);
}
