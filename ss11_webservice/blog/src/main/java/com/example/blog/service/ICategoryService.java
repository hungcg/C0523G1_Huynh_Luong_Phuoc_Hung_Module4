package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryService {
    List<Category> showAll();

    boolean add(Category category);

    Category findById(int id);

    boolean update(Category category);

    boolean delete(int id);
}

