package com.spring.features.Spring.Features.services;

import com.spring.features.Spring.Features.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> findAll();
    public Optional<Product> find(Long id);
    public Product create(Product product);
    public Product update(Long id, Product product);
    public void delete(Long id);
}
