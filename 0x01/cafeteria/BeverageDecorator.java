import java.util.List;

public abstract class BeverageDecorator extends Beverage {
    protected Beverage decoratedBeverage;

    public BeverageDecorator(Beverage beverage) {
        this.decoratedBeverage = beverage;
    }

    @Override
    public List<String> getIngredients() {
        return decoratedBeverage.getIngredients();
    }

    @Override
    public double getPrice() {
        return decoratedBeverage.getPrice();
    }
}
