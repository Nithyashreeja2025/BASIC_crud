package com.steffi.ordersandproducts.repository;

import com.steffi.ordersandproducts.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByProductId(int productId);
}
