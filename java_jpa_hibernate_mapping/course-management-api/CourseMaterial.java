import javax.persistence.*;

@Entity
@Table(name="course_materials")
public class CourseMaterial {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=255, nullable=false)
    private String url;

    @OneToOne
    @JoinColumn(name="course_id", unique = true)
    private Course course;

    public CourseMaterial() {}
    public CourseMaterial(String url) { this.url = url; }

    public Long getId() { return id; }
    public String getUrl() { return url; }
    public void setUrl(String v) { this.url = v; }
    public Course getCourse() { return course; }
    public void setCourse(Course c) { this.course = c; }
}
