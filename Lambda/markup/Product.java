import java.util.function.Supplier;
import java.util.function.Consumer;

public class Product {
    private String name;
    private double price;
    private double markupPercentage = 10.0; // default 10%

    public Supplier<Double> priceWithMarkup = () -> 
        price + (price * markupPercentage / 100);

    public Consumer<Double> updateMarkup = (newMarkup) -> 
        this.markupPercentage = newMarkup;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
