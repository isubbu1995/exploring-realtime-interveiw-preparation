package com.example.Inventory_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PutMapping("/update/{productId}")
    public String updateStock(@PathVariable Long productId, @RequestParam int quantity) {
        inventoryService.updateProductStock(productId, quantity);
        return "Stock update request received for product ID: " + productId;
    }

    @GetMapping("/get/{productName}")
    public Product getProductByName(@PathVariable String productName) {
        Optional<Product> productByName = inventoryService.getProductByName(productName);
        Product product = new Product();
        product.setName("dummyProduct");
        return productByName.orElse(product);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
       return inventoryService.saveProduct(product);
    }

}

