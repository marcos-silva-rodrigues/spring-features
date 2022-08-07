package com.spring.features.Spring.Features.repositories;

import com.spring.features.Spring.Features.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
