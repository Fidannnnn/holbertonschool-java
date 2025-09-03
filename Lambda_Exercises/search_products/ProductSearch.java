import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
    public static List<Product> filter(List<Product> products, FilterCriteria criteria) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (criteria.test(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}