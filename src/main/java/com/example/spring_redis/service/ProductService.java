package com.example.spring_redis.service;

import com.example.spring_redis.entity.Product;
import com.example.spring_redis.repo.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public Product save(Product product){
        return productDao.save(product);
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public Product findProductById(String id){
        return productDao.findProductById(id);
    }

    public String deleteProduct(String id){
        return productDao.deleteProduct(id);
    }
}
