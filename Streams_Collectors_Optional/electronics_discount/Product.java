import java.util.Locale;

public class Product {
    private final int code;
    private final String name;
    private final ProductCategory category;
    private double price;

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

    // 🔹 required for this exercise
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        // Keep comma decimals like your previous tasks
        return String.format(Locale.GERMANY, "[%d] %s %s $ %.2f",
                code, name, category, price);
    }
}
