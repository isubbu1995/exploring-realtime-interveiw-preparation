package multithreadingExp.productBased;

import java.util.List;

public class UserBrowsingHistory {
    private Long userId;
    private List<Product> viewedProducts;

    public UserBrowsingHistory(Long userId, List<Product> viewedProducts) {
        this.userId = userId;
        this.viewedProducts = viewedProducts;
    }

    // Getters and toString() method
    public Long getUserId() {
        return userId;
    }

    public List<Product> getViewedProducts() {
        return viewedProducts;
    }

    @Override
    public String toString() {
        return "UserBrowsingHistory{" +
                "userId=" + userId +
                ", viewedProducts=" + viewedProducts +
                '}';
    }
}

