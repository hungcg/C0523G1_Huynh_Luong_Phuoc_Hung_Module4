package com.example.products.repository;

import com.example.products.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void create(Product product);

    Product findById(Integer id);

    void edit(Integer id, Product product);

    void delete(Integer id);
}

