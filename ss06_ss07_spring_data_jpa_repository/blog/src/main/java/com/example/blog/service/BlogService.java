package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Blog> findAllByTitleContaining(Pageable pageable,String title) {
        return repository.findAllByTitleContaining(pageable,title);
    }

    @Override
    public boolean create(Blog blog) {
        Blog blog1 = repository.save(blog);
        return blog1 != null;
    }

    @Override
    public boolean edit(Blog blog) {
        Blog blog1 = repository.save(blog);
        return blog1 != null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Blog blog1 = findById(id);
            repository.delete(blog1);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).get();
    }
}
