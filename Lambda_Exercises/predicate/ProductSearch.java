import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
// static List <Product> filter
// static List filter
// static List" filter
// static List" <Product> filter
// static List"<Product> filter
// "static List filter
//  "public static List filter" 
    //  "public static List" 
    //public static List filter
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
