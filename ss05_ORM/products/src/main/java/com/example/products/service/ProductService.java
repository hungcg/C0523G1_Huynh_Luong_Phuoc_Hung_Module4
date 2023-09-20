package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public void update(int id, Product product) {
        repository.update(id,product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }
}