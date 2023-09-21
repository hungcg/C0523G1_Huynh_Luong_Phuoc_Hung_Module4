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
    public boolean add(Product product) {
       return repository.add(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return repository.update(id,product);
    }

    @Override
    public boolean delete(int id) {
      return   repository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }
}
