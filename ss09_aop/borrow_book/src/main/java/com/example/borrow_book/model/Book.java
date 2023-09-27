package com.example.borrow_book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private int id;
    @Column(columnDefinition = "varchar(100) not null")
    private String name;
    @Column(columnDefinition = "int not null")
    private int quantity;
    @Column(columnDefinition = "int not null")
    private int currentQuantity;
    @OneToMany(mappedBy = "book")
    private Set<CodeRandom> randomCodeSet;

    public Book() {
    }

    public Book(int id, String name, int quantity, int currentQuantity, Set<CodeRandom> randomCodeSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.currentQuantity = currentQuantity;
        this.randomCodeSet = randomCodeSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public Set<CodeRandom> getRandomCodeSet() {
        return randomCodeSet;
    }

    public void setRandomCodeSet(Set<CodeRandom> randomCodeSet) {
        this.randomCodeSet = randomCodeSet;
    }
}
