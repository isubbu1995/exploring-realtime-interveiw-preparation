package com.example.Manages_customer_orders;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private static final String TOPIC= "order";
    private OrderRepository orderRepository;
    private RestTemplate restTemplate;
    private InventoryClient inventoryClient;

    private KafkaTemplate<String, CustomerOrder> kafkaTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate, InventoryClient inventoryClient, KafkaTemplate<String, CustomerOrder> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
        this.inventoryClient = inventoryClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public CustomerOrder placeOrderKafka(CustomerOrder order) {
        orderRepository.save(order);
        kafkaTemplate.send(TOPIC, order);
        System.out.println("Order placed and event published to Kafka: " + order);
        return order;
    }

    public CustomerOrder placeOrder(CustomerOrder order) {
        // Using RestTemplate
        Product forObject = restTemplate.getForObject("http://INVENTORY-MANAGEMENT-SYSTEM/inventory/get/" + order.getProductName(), Product.class);
        if (forObject != null && forObject.getQuantity() >= order.getQuantity()) {
             inventoryClient.updateStock(forObject.getId(), (forObject.getQuantity() - order.getQuantity()));
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product is out of stock");
        }
    }

    public CustomerOrder placeOrderWithFeign(CustomerOrder order) {
        // Using FeignClient
        Product product = inventoryClient.getProductByName(order.getProductName());
        if (product != null && product.getQuantity() >= order.getQuantity()) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product is out of stock");
        }
    }
}
