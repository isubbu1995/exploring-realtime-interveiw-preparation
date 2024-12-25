package com.example.Product_Catalog_Caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductCatalogCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogCachingApplication.class, args);
	}

}
