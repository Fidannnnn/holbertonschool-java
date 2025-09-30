package com.example.jpah2demo.controller;

import com.example.jpah2demo.model.Address;
import com.example.jpah2demo.model.Customer;
import com.example.jpah2demo.model.Phone;
import com.example.jpah2demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Customer> addClient(@RequestBody Customer customer) {
        // Ensure child->parent links are set for cascade to work
        if (customer.getPhones() != null) {
            for (Phone p : customer.getPhones()) {
                p.setCustomer(customer);
            }
        }
        if (customer.getAddresses() != null) {
            for (Address a : customer.getAddresses()) {
                a.setCustomer(customer);
            }
        }
        Customer saved = customerRepository.save(customer);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Customer>> findAllClients() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Customer> findClientById(@PathVariable("id") Long idClient) {
        Optional<Customer> c = customerRepository.findById(idClient);
        return c.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCustomer(@PathVariable("id") Long idClient){
        if (customerRepository.existsById(idClient)) {
            customerRepository.deleteById(idClient);
        }
        // If not found, do nothing (204 per assignment style)
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        customerRepository.findById(id).ifPresent(existing -> {
            existing.setFirstName(customer.getFirstName());
            existing.setLastName(customer.getLastName());
            existing.setEmail(customer.getEmail());

            // Replace phones
            existing.getPhones().clear();
            if (customer.getPhones() != null) {
                for (Phone p : customer.getPhones()) {
                    p.setCustomer(existing);
                    existing.getPhones().add(p);
                }
            }

            // Replace addresses
            existing.getAddresses().clear();
            if (customer.getAddresses() != null) {
                for (Address a : customer.getAddresses()) {
                    a.setCustomer(existing);
                    existing.getAddresses().add(a);
                }
            }
            customerRepository.save(existing);
        });
        // If not found, per assignment spec we simply return 204 (no upsert)
    }
}
