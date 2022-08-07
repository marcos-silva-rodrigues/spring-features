package com.spring.features.Spring.Features.resources;

import com.spring.features.Spring.Features.models.Product;
import com.spring.features.Spring.Features.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Product> find(@PathVariable("id") Long id) {
        return this.productService.find(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return this.productService.create(product);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        return this.productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.productService.delete(id);
    }

}
