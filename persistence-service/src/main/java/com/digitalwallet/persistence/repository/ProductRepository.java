package com.digitalwallet.persistence.repository;

import com.digitalwallet.persistence.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Mono<Boolean> existsBySku(String sku);
}