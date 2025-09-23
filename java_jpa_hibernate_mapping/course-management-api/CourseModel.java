import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseModel {
    public static Course save(EntityManager em, Course c) {
        if (c.getId() == null) {
            em.persist(c);
            return c;
        } else {
            return em.merge(c);
        }
    }

    public static Course findById(EntityManager em, Long id) {
        return em.find(Course.class, id);
    }

    public static List<Course> findAll(EntityManager em) {
        TypedQuery<Course> q = em.createQuery("SELECT c FROM Course c", Course.class);
        return q.getResultList();
    }
}
