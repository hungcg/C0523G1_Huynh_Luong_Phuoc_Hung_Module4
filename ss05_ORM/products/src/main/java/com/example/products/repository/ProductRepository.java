package com.example.products.repository;

import com.example.products.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void update(int id, Product product) {
        Product productUpdate = findById(id);
        productUpdate.setName(product.getName());
        productUpdate.setDescription(product.getDescription());
        productUpdate.setPrice(product.getPrice());
        productUpdate.setSupplier(product.getSupplier());
        entityManager.merge(productUpdate);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product productDelete = findById(id);
        entityManager.remove(productDelete);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }
}
