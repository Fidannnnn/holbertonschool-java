import java.util.List;
import java.util.Locale;

public class Person implements Comparable<Person> {
    private final int code;
    private final String name;
    private final String position;
    private final int age;
    private final double salary;
    private final List<String> hobbies;

    public Person(int code, String name, String position, int age, double salary, List<String> hobbies) {
        this.code = code;
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
        this.hobbies = hobbies;
    }

    public int getCode() { return code; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public List<String> getHobbies() { return hobbies; }

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
