import java.util.Locale;

public class Product {
    private String name;
    private double price;
    private double weight;
    private int stockQuantity;
    private ProductTypes type;

    public Product(String name, double price, double weight, int stockQuantity, ProductTypes type) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.stockQuantity = stockQuantity;
        this.type = type;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getWeight() { return weight; }
    public int getStockQuantity() { return stockQuantity; }
    public ProductTypes getType() { return type; }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%s %.6f %.6f %d %s",
                name, price, weight, stockQuantity, type);
    }
}
