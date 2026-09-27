package com.digitalwallet.persistence.controller;

import com.digitalwallet.persistence.entity.Product;
import com.digitalwallet.persistence.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/internal/v1/products")
public class ProductPersistenceController {

    private final ProductRepository productRepository;

    public ProductPersistenceController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> findById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/exists-by-sku/{sku}")
    public Mono<Boolean> existsBySku(@PathVariable String sku) {
        return productRepository.existsBySku(sku);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> save(@RequestBody Product product) {
        return productRepository.save(product);
    }
}