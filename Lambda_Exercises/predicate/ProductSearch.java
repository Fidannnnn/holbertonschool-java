import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ProductSearch {
    public static List<Product> filter(List<Product> products, Predicate<Product> predicate) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (predicate.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
