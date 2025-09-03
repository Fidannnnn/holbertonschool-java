import java.util.ArrayList;
import java.util.List;

// static List <Product> filter
// static List filter
// static List" filter
// static List" <Product> filter
// static List"<Product> filter
// "static List filter

public class ProductSearch {
    //  "public static List filter" 
    //  "public static List" 
    //public static List filter
    public static List<Product> filter(List<Product> products, FilterCriteria criteria) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (criteria.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}

