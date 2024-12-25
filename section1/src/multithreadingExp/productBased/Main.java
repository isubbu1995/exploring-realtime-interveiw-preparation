package multithreadingExp.productBased;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sample products and browsing history
        Product product1 = new Product(1L, "Product 1", "Electronics");
        Product product2 = new Product(2L, "Product 2", "Books");
        List<Product> viewedProducts = Arrays.asList(product1, product2);

        UserBrowsingHistory history = new UserBrowsingHistory(1L, viewedProducts);

        // Generate recommendations
        RecommendationEngine recommendationEngine = new RecommendationEngine();
        List<Product> recommendations = recommendationEngine.generateRecommendations(history);

        // Display recommendations
        System.out.println("Recommended Products: ");
        for (Product product : recommendations) {
            System.out.println(product);
        }
    }
}

