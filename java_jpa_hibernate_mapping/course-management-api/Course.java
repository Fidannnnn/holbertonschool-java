import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=150)
    private String title;

    @Column(nullable=false)
    private int credits;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private CourseMaterial material;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course() {}
    public Course(String title, int credits) {
        this.title = title; this.credits = credits;
    }

    /* helpers */
    public void setMaterial(CourseMaterial m) {
        this.material = m;
        if (m != null) m.setCourse(this);
    }

    /* getters/setters */
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String v) { this.title = v; }
    public int getCredits() { return credits; }
    public void setCredits(int v) { this.credits = v; }
    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher t) { this.teacher = t; }
    public CourseMaterial getMaterial() { return material; }
    public Set<Student> getStudents() { return students; }

    @Override
    public String toString() {
        return "Course{id=" + id + ", title='" + title + "', credits=" + credits +
                ", teacher=" + (teacher != null ? teacher.getLastName() : "null") +
                ", students=" + students.size() + "}";
    }
}
