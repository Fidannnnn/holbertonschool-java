package entities;

import javax.persistence.*;

@Entity
@Table(name="phones")
public class Phone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=40, nullable=false)
    private String number;

    @Column(length=20)
    private String type; // MOBILE, HOME, etc.

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Phone() {}
    public Phone(String number, String type) {
        this.number = number; this.type = type;
    }

    public Long getId() { return id; }
    public String getNumber() { return number; }
    public void setNumber(String v) { this.number = v; }
    public String getType() { return type; }
    public void setType(String v) { this.type = v; }
    public Student getStudent() { return student; }
    public void setStudent(Student s) { this.student = s; }

    @Override
    public String toString() {
        return "Phone{id=" + id + ", number='" + number + "', type='" + type + "'}";
    }
}
