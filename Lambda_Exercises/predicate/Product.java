// File: Lambda_Exercises/predicate/Product.java
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("0.000000", symbols);

        return name + " " 
                + df.format(price) + " " 
                + df.format(weight) + " " 
                + stockQuantity + " " 
                + type;
    }
}
