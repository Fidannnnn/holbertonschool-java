import java.util.ArrayList;
import java.util.List;

// static List <Product> filter
// static List filter
// static List" filter
// static List" <Product> filter
// static List"<Product> filter

public class ProductSearch {
    //  "public static List filter" 
    //  "public static List" 
    public static List filter(List products, FilterCriteria criteria) {
        List result = new ArrayList();
        for (Object o : products) {
            Product p = (Product) o;            // safe for your current usage
            if (criteria.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
