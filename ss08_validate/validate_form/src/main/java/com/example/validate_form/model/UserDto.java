package com.example.validate_form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class UserDto implements Validator {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
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
        if (userDto.getPhoneNumber().equals("")) {
            errors.rejectValue("phoneNumber", null, "this field cannot empty");
        } else if (!userDto.getPhoneNumber().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phoneNumber", null, "the phone number invalid,phone number" +
                    " start with 0 and total 10 number");
        }
        if (userDto.getFirstName().equals("")) {
            errors.rejectValue("firstName", null, "this field cannot empty");
        } else if (userDto.getFirstName().matches("^(?=.{5,45}$)[A-Za-z]{5,45}$")) {
            errors.rejectValue("firstName", null, "the first name invalid,only alphabet" +
                    " character and character iz 5, max iz 45");
        }
        if (userDto.getFirstName().equals("")) {
            errors.rejectValue("lastName", null, "this field cannot empty");
        } else if (userDto.getFirstName().matches("^(?=.{5,45}$)[A-Za-z]{5,45}$")) {
            errors.rejectValue("lastName", null, "the last name invalid,only alphabet" +
                    " character and character iz 5, max iz 45");
        }
        if (userDto.getEmail().equals("")) {
            errors.rejectValue("email", null, "this field cannot empty");
        } else if (!userDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", null, "Email invalid, example :example@example.com");
        }
    }
}
