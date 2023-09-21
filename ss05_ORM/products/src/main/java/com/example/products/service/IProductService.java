package com.example.products.service;

import com.example.products.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add (Product product);
    boolean update(int id,Product product);
    boolean delete(int id);
    Product findById(int id);
}
