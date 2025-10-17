import java.util.List;

public abstract class Beverage {
    public abstract List<String> getIngredients();
    public abstract double getPrice();

    @Override
    public String toString() {
        return String.format("Price: %.2f - Ingredients: %s", getPrice(), getIngredients());
    }
}
