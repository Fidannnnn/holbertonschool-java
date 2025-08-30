import java.util.Locale;
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
        // force comma for decimal separator
        return String.format(Locale.GERMANY, "[%s] $ %.6f", description, value);
    }
}
