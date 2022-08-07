package com.spring.features.Spring.Features.services;

import com.spring.features.Spring.Features.models.Product;
import com.spring.features.Spring.Features.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> find(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> productExists = this.productRepository.findById(id);
        productExists.ifPresent(oldProduct -> {
            product.setId(oldProduct.getId());
            this.productRepository.save(product);
        });

        if (productExists.isPresent()) {
            return product;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Product> productExists = this.productRepository.findById(id);
        productExists.ifPresent(product -> this.productRepository.deleteById(product.getId()));
    }
}
