import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Query {

    public static List<Order> getOrdersWithElectronics(List<Order> orders) {
        if (orders == null) return List.of();
        return orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory() == ProductCategory.ELECTRONIC))
                .collect(Collectors.toList());
    }

    public static List<Product> getBooksFromOrder(Order order) {
        return order.getProducts().stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK)
                .collect(Collectors.toList());
    }

    public static Product getProductWithHighestPrice(List<Product> products) {
        if (products == null || products.isEmpty()) return null;
        return products.stream()
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    public static List<Product> getProductsByMinimumPrice(List<Product> products, double minPrice) {
        if (products == null) return List.of();
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }
}
