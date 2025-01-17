package com.example.spring_redis.repo;

import com.example.spring_redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    public static final String HASH_KEY = "Product";

    @Autowired
    RedisTemplate redisTemplate;

    public Product save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(String id){
        return (Product)redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(String id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Product deleted!";
    }
}
