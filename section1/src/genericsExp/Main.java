package multithreadingExp.genericsExp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create repositories for different entities
        GenericRepository<Product, Long> productRepository = new InMemoryRepository<>();
        GenericRepository<Customer, Long> customerRepository = new InMemoryRepository<>();
        GenericRepository<Order, Long> orderRepository = new InMemoryRepository<>();

        // Create and save products
        Product product1 = new Product(1L, "Laptop", 999.99);
        Product product2 = new Product(2L, "Smartphone", 499.99);
        productRepository.save(product1);
        productRepository.save(product2);

        // Create and save customers
        Customer customer1 = new Customer(1L, "Alice", "alice@example.com");
        Customer customer2 = new Customer(2L, "Bob", "bob@example.com");
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        // Create and save orders
        Order order1 = new Order(1L, customer1.getId(), Arrays.asList(product1));
        Order order2 = new Order(2L, customer2.getId(), Arrays.asList(product2));
        orderRepository.save(order1);
        orderRepository.save(order2);

        // Find and display all products
        System.out.println("All Products:");
        productRepository.findAll().forEach(System.out::println);

        // Find and display all customers
        System.out.println("\nAll Customers:");
        customerRepository.findAll().forEach(System.out::println);

        // Find and display all orders
        System.out.println("\nAll Orders:");
        orderRepository.findAll().forEach(System.out::println);
    }
}

