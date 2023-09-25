package com.example.validate_form.service;

import com.example.validate_form.model.User;
import com.example.validate_form.model.UserDto;
import com.example.validate_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> showAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(User user) {
        User user1 = repository.save(user);
        return user1 != null;
    }
}
