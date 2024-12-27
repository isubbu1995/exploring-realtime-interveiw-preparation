package com.example.Product_Catalog_Caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProducts(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/evict")
    public String evict(){
        productService.evictCache();
        return "All cache removed!!!";
    }
}
