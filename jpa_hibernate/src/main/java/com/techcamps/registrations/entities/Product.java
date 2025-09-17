package com.techcamps.registrations.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String name;

    private Integer quantity;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;

    private Boolean status;

    public Product() {}

    // Getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    @Override public String toString() {
        return "Product{id=" + id + ", name='" + name + "', qty=" + quantity + ", price=" + price + ", status=" + status + "}";
    }
}
