package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> showAll() {
        return repository.findAll();
    }

    @Override
    public boolean add(Blog blog) {
        Blog blog1 = repository.save(blog);
        return blog1 != null;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean update(Blog blog) {
        Blog blog1 = repository.save(blog);
        return blog1 != null;
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }
}
