import java.util.List;
import java.util.stream.Collectors;

public class Query {
    public static List<Product> getBooksFromOrder(Order order) {
        return order.getProducts().stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK)
                .collect(Collectors.toList()); // or .toList() on Java 16+
    }
}
