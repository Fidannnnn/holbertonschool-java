import java.lang.reflect.Method;
    import java.lang.reflect.Parameter;
    import java.util.*;
    import java.util.function.*;

    public class Program {
        public static void main(String[] args) {
            Product product1 = new Product("Truffled Chocolate Coffee",
                21.99, 250, 120, ProductTypes.KITCHEN);     

            Product product2 = new Product("Condensed Milk",
                6.29, 395, 200, ProductTypes.KITCHEN);     

            Product product3 = new Product("Vortex Car",
                799.90, 1560, 5, ProductTypes.TOY);  

            Product product4 = new Product("Smart TV LED 32 HD LG",
                1452.55, 6300, 7, ProductTypes.ELECTRONIC);              

            Product product5 = new Product("Nintendo Switch",
                2990.00, 1700, 12, ProductTypes.ELECTRONIC);   

            List<Product> products = Arrays.asList(
                product1, product2, product3, product4, product5);   

            List<Product> productsPriceGreaterThan100 = ProductSearch.filter(products, 
                p -> p.getPrice() > 100);

            List<Product> productsWeightLessOrEqual1600 = ProductSearch.filter(products, 
                p -> p.getWeight() <= 1600);          

            List<Product> kitchenProducts = ProductSearch.filter(products, 
                p -> p.getType() == ProductTypes.KITCHEN);   

            List<Product> lowStockProducts = ProductSearch.filter(products, 
                p -> p.getStockQuantity() <= 10);      

            try
            {
                Method method = ProductSearch.class.getMethod("filter", List.class, Predicate.class);
                if (method != null) {
                    System.out.println("Method found");
                }
            } catch(NoSuchMethodException ex) {
                System.out.println("Method not found");
            }

            System.out.println(productsPriceGreaterThan100);
            System.out.println(productsWeightLessOrEqual1600);
            System.out.println(kitchenProducts);
            System.out.println(lowStockProducts);
        }
    }    