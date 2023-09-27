package com.example.borrow_book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private int id;
    @Column(columnDefinition = "varchar(100) not null")
    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<CodeRandom> randomCodeSet;

    public Customer() {
    }

    public Customer(int id, String name, Set<CodeRandom> randomCodeSet) {
        this.id = id;
        this.name = name;
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

    public Set<CodeRandom> getRandomCodeSet() {
        return randomCodeSet;
    }

    public void setRandomCodeSet(Set<CodeRandom> randomCodeSet) {
        this.randomCodeSet = randomCodeSet;
    }
}
