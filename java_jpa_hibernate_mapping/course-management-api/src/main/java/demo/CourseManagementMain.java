package demo;

import entities.*;
import models.CourseModel;
import models.StudentModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CourseManagementMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("coursePU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Teacher
            Teacher t = new Teacher("Alan", "Turing", "alan@uni.edu");
            em.persist(t);

            // Course + material
            Course c1 = new Course("Discrete Math", 6);
            c1.setTeacher(t);
            CourseMaterial m1 = new CourseMaterial("https://materials.example/discrete-math.pdf");
            c1.setMaterial(m1);
            em.persist(c1);
            em.persist(m1);

            Course c2 = new Course("Algorithms", 5);
            c2.setTeacher(t);
            CourseMaterial m2 = new CourseMaterial("https://materials.example/algorithms.pdf");
            c2.setMaterial(m2);
            em.persist(c2);
            em.persist(m2);

            // Students
            Student s1 = new Student("Ada", "Lovelace", "ada@uni.edu",
                    new Address("42 Logic St", "Baku", "AZ1000"));
            s1.addPhone(new Phone("050-111-22-33", "MOBILE"));
            s1.addPhone(new Phone("012-555-66-77", "HOME"));

            Student s2 = new Student("Grace", "Hopper", "grace@uni.edu",
                    new Address("1 Compiler Ave", "Baku", "AZ1002"));
            s2.addPhone(new Phone("051-333-44-55", "MOBILE"));

            // Enrollments (Many-to-Many)
            StudentModel.enroll(em, s1, c1);
            StudentModel.enroll(em, s1, c2);
            StudentModel.enroll(em, s2, c2);

            em.getTransaction().commit();

            // Read back
            System.out.println("All students:");
            List<Student> students = StudentModel.findAll(em);
            for (Student st : students) {
                System.out.println(st);
            }

            System.out.println("All courses:");
            List<Course> courses = CourseModel.findAll(em);
            for (Course c : courses) {
                System.out.println(c);
            }

        } finally {
            em.close();
            emf.close();
        }
    }
}
