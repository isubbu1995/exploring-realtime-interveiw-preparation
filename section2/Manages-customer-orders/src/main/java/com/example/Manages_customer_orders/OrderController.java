package com.example.Manages_customer_orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeKafka")
    public CustomerOrder placeOrderKafka(@RequestBody CustomerOrder order) {
        return orderService.placeOrderKafka(order);
    }

    @PostMapping("/place")
    public CustomerOrder placeOrder(@RequestBody CustomerOrder order) {
        return orderService.placeOrder(order);
    }

    @PostMapping("/place-feign")
    public CustomerOrder placeOrderWithFeign(@RequestBody CustomerOrder order) {
        return orderService.placeOrderWithFeign(order);
    }
}
