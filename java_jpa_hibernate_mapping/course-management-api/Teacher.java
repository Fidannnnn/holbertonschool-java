import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String firstName;

    @Column(nullable=false, length=100)
    private String lastName;

    @Column(length=150, unique=true)
    private String email;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Teacher() {}
    public Teacher(String firstName, String lastName, String email) {
        this.firstName = firstName; this.lastName = lastName; this.email = email;
    }

    /* helpers */
    public void addCourse(Course c) {
        c.setTeacher(this);
        courses.add(c);
    }

    /* getters/setters */
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String v) { this.firstName = v; }
    public String getLastName() { return lastName; }
    public void setLastName(String v) { this.lastName = v; }
    public String getEmail() { return email; }
    public void setEmail(String v) { this.email = v; }
    public List<Course> getCourses() { return courses; }
}
