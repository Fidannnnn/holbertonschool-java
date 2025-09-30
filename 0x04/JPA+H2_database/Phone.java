package com.example.jpah2demo.model;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;   // e.g., "+994-50-123-45-67"
    private String type;     // e.g., "mobile", "home", "work"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Phone() {}
    public Phone(Long id, String number, String type) {
        this.id = id; this.number = number; this.type = type;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
