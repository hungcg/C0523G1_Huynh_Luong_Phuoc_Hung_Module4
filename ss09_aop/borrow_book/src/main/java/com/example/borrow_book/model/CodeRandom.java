package com.example.borrow_book.model;

import javax.persistence.*;

@Entity
public class CodeRandom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private  int id;
    @Column(columnDefinition = "varchar(5) not null")
    private String code;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    public CodeRandom() {
    }

    public CodeRandom(String code, Book book) {
        this.code = code;
        this.book = book;
    }

    public CodeRandom(int id, String code, Book book, Customer customer) {
        this.id = id;
        this.code = code;
        this.book = book;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
