package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> showAll() {
        return repository.findAll();
    }

    @Override
    public boolean add(Category category) {
        Category category1 = repository.save(category);
        return category1!=null;
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean update(Category category) {
        Category category1= repository.save(category);
        return category1!=null;
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }
}
