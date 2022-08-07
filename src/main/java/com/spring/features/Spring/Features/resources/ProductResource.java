package com.spring.features.Spring.Features.resources;

import com.spring.features.Spring.Features.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @GetMapping
    @ResponseBody
    public List<Product> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Product> find(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/(id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
    }

}
