package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> showAll();

    boolean save(Book book);

    boolean delete(Book book);

    Book findById(int id);
}
