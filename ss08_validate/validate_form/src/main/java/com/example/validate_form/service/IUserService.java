package com.example.validate_form.service;

import com.example.validate_form.model.User;
import com.example.validate_form.model.UserDto;

import java.util.List;

public interface IUserService {
    List<User> showAll();

    boolean create(User user);

}
