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

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        // force comma for decimal separator
        return String.format(Locale.GERMANY, "[%s] %.6f $ %.6f", name, calories, price);
    }
}
