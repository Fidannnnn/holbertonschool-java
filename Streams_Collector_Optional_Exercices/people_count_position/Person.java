import java.util.Locale;

public class Person implements Comparable<Person> {
    private final int code;
    private final String name;
    private final String position;
    private final int age;
    private final double salary;

    public Person(int code, String name, String position, int age, double salary) {
        this.code = code;
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public int getCode() { return code; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public int compareTo(Person other) {
        int byName = this.name.compareTo(other.name);
        if (byName != 0) return byName;
        return Integer.compare(this.code, other.code);
    }

    @Override
    public String toString() {
        return String.format(Locale.GERMANY, "[%d] %s %s %d $ %.6f",
                code, name, position, age, salary);
    }
}
