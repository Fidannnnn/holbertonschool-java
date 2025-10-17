import java.util.ArrayList;
import java.util.List;

public class CoffeeBeverage extends Beverage {

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("coffee");
        return ingredients;
    }

    @Override
    public double getPrice() {
        return 5.35;
    }
}
