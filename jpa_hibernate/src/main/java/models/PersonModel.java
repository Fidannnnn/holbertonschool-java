package models;

import entities.Person;

import javax.persistence.*;
import java.util.List;

public class PersonModel {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("admin-jpa");

    private EntityManager em() {
        return emf.createEntityManager();
    }

    public void create(Person p) {
        EntityManager em = em();
        try {
            System.out.println("Starting transaction (Person.create)");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Person created successfully!");
        } catch (Exception e) {
            System.err.println("Error creating person: " + e.getMessage());
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
            System.out.println("Transaction completed");
        }
    }

    public Person update(Person p) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            Person merged = em.merge(p);
            em.getTransaction().commit();
            System.out.println("Person updated successfully!");
            return merged;
        } catch (Exception e) {
            System.err.println("Error updating person: " + e.getMessage());
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    public void delete(Person p) {
        if (p == null || p.getId() == null) return;
        deleteById(p.getId());
    }

    public void deleteById(Long id) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            Person managed = em.find(Person.class, id);
            if (managed != null) {
                em.remove(managed);
                System.out.println("Person deleted successfully!");
            } else {
                System.out.println("Person not found, nothing to delete.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error deleting person: " + e.getMessage());
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Person findById(Long id) {
        EntityManager em = em();
        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }

    public List<Person> findAll() {
        EntityManager em = em();
        try {
            return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        } finally {
            em.close();
        }
    }
}
