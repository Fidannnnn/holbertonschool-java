import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int age;
    private String name;
    private transient String password; // must not be serialized

    public Student(int age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "Student { name='" + name + "', age='" + age + "', password='" + password + "' }";
    }
}
