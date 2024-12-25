package com.example.Inventory_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private ProductRepository productRepository;

    @KafkaListener(topics = "order", groupId = "inventory-group")
    public void consume(CustomerOrder order) {
        Product product = productRepository.findByName(order.getProductName());
        if (product != null) {
            product.setQuantity(product.getQuantity() - order.getQuantity());
            productRepository.save(product);
            System.out.println("Inventory updated for product: " + product.getName());
        }
    }

        public Optional<Product> getProductByName(String name){
            return Optional.ofNullable(productRepository.findByName(name));
        }

        @Async
        public void updateProductStock (Long productId,int quantity){
            Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
            product.setQuantity(quantity);
            productRepository.save(product);
            System.out.println("Updated stock for product: " + product.getName() + " to " + quantity);
        }

        //@Scheduled(fixedRate = 10000)
        public void checkInventoryLevels () {
            System.out.println("Checking inventory levels...");
            productRepository.findAll().forEach(product -> {
                if (product.getQuantity() < 10) {
                    System.out.println("Product " + product.getName() + " is low on stock.");
                }
            });
            System.out.println("Checking inventory levels...finished!!!");
        }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
