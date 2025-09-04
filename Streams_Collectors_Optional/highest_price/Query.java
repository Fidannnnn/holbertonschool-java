import java.util.List;
import java.util.Comparator;

public class Query {
    public static Product getProductWithHighestPrice(List<Product> products) {
        if (products == null || products.isEmpty()) return null;
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .findFirst()
                .orElse(null);
    }
}
