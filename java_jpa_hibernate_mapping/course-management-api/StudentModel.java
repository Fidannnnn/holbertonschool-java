import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentModel {

    public static Student save(EntityManager em, Student s) {
        if (s.getId() == null) {
            em.persist(s);
            return s;
        } else {
            return em.merge(s);
        }
    }

    public static Student findById(EntityManager em, Long id) {
        return em.find(Student.class, id);
    }

    public static List<Student> findAll(EntityManager em) {
        TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s", Student.class);
        return q.getResultList();
    }

    public static void enroll(EntityManager em, Student s, Course c) {
        // persist if new
        if (s.getId() == null) em.persist(s);
        if (c.getId() == null) em.persist(c);
        // link both sides
        s.addCourse(c);
    }
}
