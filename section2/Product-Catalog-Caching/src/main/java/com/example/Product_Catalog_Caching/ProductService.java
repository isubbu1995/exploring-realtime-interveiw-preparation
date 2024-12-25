package com.example.Product_Catalog_Caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Cacheable("products")
    public List<Product> getAllProducts() {
        System.out.println("Fetching products from the database...");
        return productRepository.findAll();
    }

    @Cacheable(value = "product", key = "#id")
    public Product getProductById(Long id) {
        System.out.println("Fetching product from the database...");
        return productRepository.findById(id).orElse(null);
    }

    @Cacheable("product")
    public Product save(Product product) {
        Product save = productRepository.save(product);
        System.out.println("Saved product to the database..."+save);
        return save;
    }

    @CacheEvict(value = "products",allEntries = true)
    public void evictCache() {
        System.out.println("evictCache Method called");
    }
}

