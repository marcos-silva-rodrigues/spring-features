package com.spring.features.Spring.Features.resources;

import com.spring.features.Spring.Features.models.Product;
import com.spring.features.Spring.Features.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@Api("API REST - Model Product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Find All products in database")
    public ResponseEntity<?> findAll() {
        List<Product> list = this.productService.findAll();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Find by id in database")
    public ResponseEntity<?> find(@PathVariable("id") Long id) {
        Optional<Product> product = this.productService.find(id);
        return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new product")
    public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors errors) {
        if (!errors.hasErrors()) {
            Product productCreated = this.productService.create(product);
            return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);
        }
        String collect = errors.getAllErrors()
                .stream()
                .map(msg -> msg.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(collect);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Update a product by id")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Product product, Errors errors) {

        if (!errors.hasErrors()) {
            Product productUpdated = this.productService.update(id, product);
            return new ResponseEntity<Product>(productUpdated, HttpStatus.CREATED);
        }
        String collect = errors.getAllErrors()
                .stream()
                .map(msg -> msg.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(collect);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete product by id")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
