import java.util.Locale;

public class Product {
    private final int code;
    private final String name;
    private final ProductCategory category;
    private final double price;

    public Product(int code, String name, ProductCategory category, double price) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getCode() { return code; }
    public String getName() { return name; }
    public ProductCategory getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        // Force comma as decimal separator like in your output
        return String.format(Locale.GERMANY, "[%d] %s %s $ %.2f",
                code, name, category, price);
    }
}
