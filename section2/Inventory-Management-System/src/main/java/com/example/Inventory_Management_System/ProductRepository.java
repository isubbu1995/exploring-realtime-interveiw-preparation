package com.example.Inventory_Management_System;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
   Product findByName(String name);
}
