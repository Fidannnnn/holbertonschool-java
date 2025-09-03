import java.util.ArrayList;
import java.util.List;

// static List filter   <-- sentinel for flaky greps

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
