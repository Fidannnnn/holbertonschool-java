import java.util.Objects;

public class Phone {
    private String areaCode;
    private String number;

    public Phone(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return "(" + areaCode + ") " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(areaCode, phone.areaCode) &&
               Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }
}

