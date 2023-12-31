package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;




    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);

    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void edit(Integer id, Product product) {
        productRepository.edit(id, product);

    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);

    }
}
