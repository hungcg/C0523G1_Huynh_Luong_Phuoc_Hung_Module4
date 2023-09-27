package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository repository;

    @Override
    public List<Book> showAll() {
       return  repository.findAll();
    }

    @Override
    public boolean save(Book book) {
        Book book1 = repository.save(book);
        return book1!=null;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id).get();
    }
}
