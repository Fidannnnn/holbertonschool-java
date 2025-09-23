package entities;

import javax.persistence.*;
import java.util.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String firstName;

    @Column(nullable=false, length=100)
    private String lastName;

    @Column(nullable=false, unique=true, length=150)
    private String email;

    @Embedded
    private Address address;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name="student_id"),
        inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private Set<Course> courses = new HashSet<>();

    public Student() {}

    public Student(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    /* helpers */
    public void addPhone(Phone p) {
        p.setStudent(this);
        phones.add(p);
    }
    public void addCourse(Course c) {
        courses.add(c);
        c.getStudents().add(this);
    }

    /* getters/setters */
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String v) { this.firstName = v; }
    public String getLastName() { return lastName; }
    public void setLastName(String v) { this.lastName = v; }
    public String getEmail() { return email; }
    public void setEmail(String v) { this.email = v; }
    public Address getAddress() { return address; }
    public void setAddress(Address v) { this.address = v; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public List<Phone> getPhones() { return phones; }
    public Set<Course> getCourses() { return courses; }

    @Override
    public String toString() {
        return "Student{id=" + id +
                ", name=" + firstName + " " + lastName +
                ", email=" + email +
                ", birthDate=" + birthDate +
                ", courses=" + courses.size() +
                ", phones=" + phones.size() + "}";
    }
}
