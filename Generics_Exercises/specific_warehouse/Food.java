import java.util.Locale;

public class Food {
    private String name;
    private double calories;
    private double price;

    public Food(String name, double calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(Locale.GERMANY, "[%s] %.6f $ %.6f", name, calories, price);
    }
}
