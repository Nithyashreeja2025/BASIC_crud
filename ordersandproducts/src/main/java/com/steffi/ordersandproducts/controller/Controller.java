package com.steffi.ordersandproducts.controller;

import com.steffi.ordersandproducts.model.Order;
import com.steffi.ordersandproducts.model.Product;
import com.steffi.ordersandproducts.repository.OrderRepository;
import com.steffi.ordersandproducts.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private ProductRepository pr;
    private OrderRepository or;

    public Controller(ProductRepository pr,OrderRepository or){
        this.pr=pr;
        this.or=or;
    }
   @GetMapping("/delivered")
    public List<Product> getProduct(){
        List<Order> orders=or.findByOrderStatus("Delivered");
        List<Product> products=new ArrayList<>();

        for(Order o:orders){
            Product p=pr.findByProductId(o.getProductId());
            int found=0;
            for(Product tp:products){
                if(tp.getProductId()==p.getProductId()){
                    found=1;
                    break;
                }

            }
            if(found==0){
            products.add(p);}
        }
        return products;
   }
}
