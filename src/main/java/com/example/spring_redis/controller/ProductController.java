package com.example.spring_redis.controller;

import com.example.spring_redis.entity.Product;
import com.example.spring_redis.repo.ProductDao;
import com.example.spring_redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable String id){
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
