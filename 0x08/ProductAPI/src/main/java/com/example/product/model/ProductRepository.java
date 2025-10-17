package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final List<Product> list = new ArrayList<>();

    public List<Product> getAllProducts() {
        return new ArrayList<>(list);
    }

    public Product getProductById(Long id) {
        if (id == null) return null;
        Optional<Product> opt = list.stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst();
        return opt.orElse(null);
    }

    public void addProduct(Product p) {
        if (p == null) return;
        // if ID not provided, generate a simple one
        if (p.getId() == null) {
            long nextId = list.stream()
                    .map(Product::getId)
                    .filter(i -> i != null)
                    .mapToLong(Long::longValue)
                    .max().orElse(0L) + 1L;
            p.setId(nextId);
        }
        list.add(p);
    }

    public void updateProduct(Product p) {
        if (p == null || p.getId() == null) return;
        for (int i = 0; i < list.size(); i++) {
            if (p.getId().equals(list.get(i).getId())) {
                list.set(i, p);
                return;
            }
        }
    }

    public void removeProduct(Product p) {
        if (p == null) return;
        list.removeIf(existing ->
                (p.getId() != null && p.getId().equals(existing.getId()))
                || p.equals(existing));
    }

    public void addList(List<Product> listOfProducts) {
        if (listOfProducts == null || listOfProducts.isEmpty()) return;
        list.addAll(listOfProducts);
    }
}
