import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
    static List<Product> filter(List<Product> products, FilterCriteria criteria) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (criteria.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
