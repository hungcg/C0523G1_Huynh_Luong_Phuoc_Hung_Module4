package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> showAll();
    boolean create(Blog blog);
    boolean edit (Blog blog);
    boolean delete (int id);
    Blog findById(int id);
}
