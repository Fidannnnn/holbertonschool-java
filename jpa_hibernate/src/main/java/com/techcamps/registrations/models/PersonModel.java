package com.techcamps.registrations.models;

import com.techcamps.registrations.entities.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class PersonModel {

    private EntityManagerFactory emf() {
        return Persistence.createEntityManagerFactory("admin-jpa");
    }

    public void create(Person p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Person created: " + p);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error creating person: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void update(Person p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Person updated: " + p);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error updating person: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void delete(Person p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Person managed = em.find(Person.class, p.getId());
            if (managed != null) em.remove(managed);
            em.getTransaction().commit();
            System.out.println("Person deleted: " + p.getId());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error deleting person: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public Person findById(Person p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Person.class, p.getId());
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            people = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
            return people;
        } finally {
            em.close();
            emf.close();
        }
    }
}
