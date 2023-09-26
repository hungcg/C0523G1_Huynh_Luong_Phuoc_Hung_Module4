package com.example.validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDto implements Validator {

    private int id;

    @NotBlank(message = "require not empty")
    @Pattern(regexp = "^^(?=.{5,45}$)[A-Za-z]{5,45}$", message = "not match regex")
    private String firstName;
    @NotBlank(message = "require not empty")
    @Pattern(regexp = "^(?=.{5,45}$)[A-Za-z]{5,45}$", message = "not match regex")
    private String lastName;
    @NotBlank(message = "require not empty")
    @Pattern(regexp = "^0[0-9]{9}$", message = "not match regex")
    private String phoneNumber;
    private int age;
    @NotBlank(message = "require not empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "not match regex")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (String.valueOf(userDto.getAge()) == "") {
            errors.rejectValue("age", null, "this field cannot empty");
        } else if (userDto.getAge() < 18) {
            errors.rejectValue("age", null, "the age cannot under 18");
        }
    }
}
