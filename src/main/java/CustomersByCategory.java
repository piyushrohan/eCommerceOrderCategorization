import java.util.*;
import java.util.stream.Collectors;

record Category(int categoryId, String categoryName) {
}

record Customer(int customerId, String customerName) {
}

record Product(int productId, String productName, Category category) {
}

record Order(int orderId, Customer customer, List<Product> products, Date orderDate) {
}

public class CustomersByCategory {
    public static Map<Category, List<String>> groupCustomersByCategory(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products().stream()
                        .map(product -> new AbstractMap.SimpleEntry<>(product.category(), order.customer().customerName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

    }
}