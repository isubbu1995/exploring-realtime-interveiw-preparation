package multithreadingExp.genericsExp;

import java.util.List;

public class Order {
    private Long id;
    private Long customerId;
    private List<Product> products;

    public Order(Long id, Long customerId, List<Product> products) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerId=" + customerId + ", products=" + products + '}';
    }
}
