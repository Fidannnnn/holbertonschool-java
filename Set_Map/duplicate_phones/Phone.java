import java.util.Objects;

public class Phone {
    private final String ddd;
    private final String number;

    public Phone(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "(" + ddd + ") " + number;
    }

    // Two phones are the same if both DDD and number match
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(ddd, phone.ddd) &&
               Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, number);
    }
}
