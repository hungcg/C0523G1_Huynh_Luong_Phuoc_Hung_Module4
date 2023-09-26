package com.example.validate_form.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(columnDefinition = "int not null")
    private int id;
    @Column(columnDefinition = "varchar(50) not null")
    private String firstName;
    @Column(columnDefinition = "varchar(50) not null")
    private String lastName;

    @Column(columnDefinition = "int not null")
    private int phoneNumber;
    @Column(columnDefinition = "int not null")
    private int age;
    @Column(columnDefinition = "varchar(50) not null")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, int phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}