package multithreadingExp.productBased;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecommendationEngine {
    private static final int THREAD_COUNT = 4;
    private ExecutorService executorService;

    public RecommendationEngine() {
        this.executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public List<Product> generateRecommendations(UserBrowsingHistory history) {
        List<Product> recommendations = new ArrayList<>();
        executorService.submit(() -> {
            // Analyze browsing history to generate recommendations
            for (Product viewedProduct : history.getViewedProducts()) {
            // Simulate recommendation logic (e.g., based on product category)
                recommendations.addAll(findSimilarProducts(viewedProduct));
            }
        });
        executorService.shutdown();
        // Wait for all tasks to complete
        while (!executorService.isTerminated()) {
            // Busy waiting (not ideal for production use)
        }

        return recommendations;
    }

    private List<Product> findSimilarProducts(Product product) {
        List<Product> similarProducts = new ArrayList<>();
        similarProducts.add(new Product(100L, "Similar Product A", product.getCategory()));
        similarProducts.add(new Product(101L, "Similar Product B", product.getCategory()));
        return similarProducts;
    }
}
