import food.Food;
import mood.*;

public class Character {
    private int happinessPoints;

    public Character() {
        this.happinessPoints = 0;
    }

    public void eat(Food[] foods) {
        if (foods == null) return;
        for (Food f : foods) {
            if (f != null) {
                this.happinessPoints += f.getHappinessPoints();
            }
        }
    }

    public Mood getCurrentMood() {
        if (happinessPoints < -5) {
            return new Angry();
        } else if (happinessPoints >= -5 && happinessPoints <= 0) {
            return new Sad();
        } else if (happinessPoints >= 1 && happinessPoints <= 15) {
            return new Happy();
        } else { // happinessPoints > 15
            return new VeryHappy();
        }
    }

    @Override
    public String toString() {
        Mood mood = getCurrentMood();
        return this.happinessPoints + " - " + mood.toString();
    }
}
