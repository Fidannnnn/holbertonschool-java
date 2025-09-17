package models;

import entities.Product;

import javax.persistence.*;
import java.util.List;

public class ProductModel {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("admin-jpa");

    private EntityManager em() {
        return emf.createEntityManager();
    }

    public void create(Product p) {
        EntityManager em = em();
        try {
            System.out.println("Starting transaction (Product.create)");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Product created successfully!");
        } catch (Exception e) {
            System.err.println("Error creating product: " + e.getMessage());
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
            System.out.println("Transaction completed");
        }
    }

    public Product update(Product p) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            Product merged = em.merge(p);
            em.getTransaction().commit();
            System.out.println("Product updated successfully!");
            return merged;
        } catch (Exception e) {
            System.err.println("Error updating product: " + e.getMessage());
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    public void delete(Product p) {
        if (p == null || p.getId() == null) return;
        deleteById(p.getId());
    }

    public void deleteById(Long id) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            Product managed = em.find(Product.class, id);
            if (managed != null) {
                em.remove(managed);
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Product not found, nothing to delete.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage());
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Product findById(Long id) {
        EntityManager em = em();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public List<Product> findAll() {
        EntityManager em = em();
        try {
            return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        } finally {
            em.close();
        }
    }
}
