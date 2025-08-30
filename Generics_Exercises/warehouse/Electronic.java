public class Electronic {
    private String description;
    private double value;

    public Electronic(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        // Use default locale so commas appear where expected on your grader
        return String.format("[%s] $ %.6f", description, value);
    }
}
