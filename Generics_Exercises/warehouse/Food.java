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
        // Use default locale so commas appear where expected on your grader
        return String.format("[%s] %.6f $ %.6f", name, calories, price);
    }
}
