package com.example.cart.service;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> showAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).get();
    }
}

