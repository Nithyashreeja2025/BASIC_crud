package com.steffi.ordersandproducts.repository;

import com.steffi.ordersandproducts.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findByOrderStatus(String orderStatus);
}
