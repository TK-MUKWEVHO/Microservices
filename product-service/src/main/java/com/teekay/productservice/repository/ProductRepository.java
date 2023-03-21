package com.teekay.productservice.repository;

import com.teekay.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, String> {
}
