package com.techcamps.registrations.demo;

import com.techcamps.registrations.entities.Product;
import com.techcamps.registrations.entities.Person;
import com.techcamps.registrations.models.ProductModel;
import com.techcamps.registrations.models.PersonModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AdminApp {
    public static void main(String[] args) {
        ProductModel productModel = new ProductModel();
        PersonModel personModel = new PersonModel();

        // --- Create Product ---
        Product tv = new Product();
        tv.setName("TV");
        tv.setPrice(new BigDecimal("300.00"));
        tv.setQuantity(100);
        tv.setStatus(true);
        productModel.create(tv);

        // --- Create Person ---
        Person betty = new Person();
        betty.setName("Betty");
        betty.setEmail("betty@techcamps.com");
        betty.setAge(27);
        betty.setCpf("111.111.111-11");
        betty.setBirthDate(new Date());
        personModel.create(betty);

        // --- Find All ---
        List<Product> products = productModel.findAll();
        System.out.println("Products count: " + products.size());
        List<Person> people = personModel.findAll();
        System.out.println("People count: " + people.size());

        // --- Update ---
        tv.setQuantity(120);
        productModel.update(tv);
        betty.setAge(28);
        personModel.update(betty);

        // --- Find by ID ---
        Product pById = productModel.findById(tv);
        System.out.println("Found product by id: " + pById);
        Person personById = personModel.findById(betty);
        System.out.println("Found person by id: " + personById);

        // --- Delete (demo) ---
        // productModel.delete(tv);
        // personModel.delete(betty);
    }
}
