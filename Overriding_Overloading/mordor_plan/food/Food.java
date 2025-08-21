package food;

public abstract class Food {
    protected int happinessPoints;

    protected Food(int happinessPoints) {
        this.happinessPoints = happinessPoints;
    }

    public int getHappinessPoints() {
        return happinessPoints;
    }
}
