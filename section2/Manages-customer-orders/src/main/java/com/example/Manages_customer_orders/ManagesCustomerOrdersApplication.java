package com.example.Manages_customer_orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ManagesCustomerOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagesCustomerOrdersApplication.class, args);
	}

}
