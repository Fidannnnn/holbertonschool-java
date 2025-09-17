package com.techcamps.registrations.models;

import com.techcamps.registrations.entities.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private EntityManagerFactory emf() {
        return Persistence.createEntityManagerFactory("admin-jpa");
    }

    public void create(Product p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Product created: " + p);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error creating product: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void update(Product p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Product updated: " + p);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error updating product: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void delete(Product p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Product managed = em.find(Product.class, p.getId());
            if (managed != null) em.remove(managed);
            em.getTransaction().commit();
            System.out.println("Product deleted: " + p.getId());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error deleting product: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public Product findById(Product p) {
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Product.class, p.getId());
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        EntityManagerFactory emf = emf();
        EntityManager em = emf.createEntityManager();
        try {
            products = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            return products;
        } finally {
            em.close();
            emf.close();
        }
    }
}
