package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogService {

    List<Blog> showAll();
    boolean add(Blog blog);

    Blog findById(int id);

    boolean update(Blog blog);

    boolean delete(int id);
}
