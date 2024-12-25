package com.example.Manages_customer_orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends JpaRepository<CustomerOrder,Long> {
}
