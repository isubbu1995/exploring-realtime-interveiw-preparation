package com.example.Manages_customer_orders;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-client",url = "http://localhost:9090/inventory")
public interface InventoryClient {

    @GetMapping("/get/{productName}")
    public Product getProductByName(@PathVariable String productName);

    @PutMapping("/update/{productId}")
    public String updateStock(@PathVariable Long productId, @RequestParam int quantity) ;

}
