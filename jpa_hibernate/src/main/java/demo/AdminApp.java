package demo;

import entities.Person;
import entities.Product;
import models.PersonModel;
import models.ProductModel;

import java.time.LocalDate;
import java.util.List;

public class AdminApp {

    public static void main(String[] args) {
        ProductModel productModel = new ProductModel();
        PersonModel personModel = new PersonModel();

        // ----- PRODUCTS -----
        Product tv = new Product();
        tv.setName("TV");
        tv.setPrice(300.0);
        tv.setQuantity(100);
        tv.setStatus(true);

        // Create
        productModel.create(tv);

        // Find all
        List<Product> products = productModel.findAll();
        System.out.println("Products found: " + products.size());

        // Update
        if (tv.getId() != null) {
            tv.setPrice(349.99);
            tv = productModel.update(tv);
            System.out.println("Updated product price: " + (tv != null ? tv.getPrice() : null));
        }

        // Find by id
        if (tv != null && tv.getId() != null) {
            Product fetched = productModel.findById(tv.getId());
            System.out.println("Fetched product: " + (fetched != null ? fetched.getName() : "null"));
        }

        // Delete
        if (tv != null && tv.getId() != null) {
            productModel.deleteById(tv.getId());
        }

        // ----- PERSONS -----
        Person alice = new Person();
        alice.setName("Alice Johnson");
        alice.setEmail("alice@example.com");
        alice.setAge(28);
        alice.setCpf("123.456.789-00");
        alice.setBirthDate(LocalDate.of(1997, 1, 15));

        // Create
        personModel.create(alice);

        // Find all
        List<Person> people = personModel.findAll();
        System.out.println("Persons found: " + people.size());

        // Update
        if (alice.getId() != null) {
            alice.setAge(29);
            alice = personModel.update(alice);
            System.out.println("Updated person age: " + (alice != null ? alice.getAge() : null));
        }

        // Find by id
        if (alice != null && alice.getId() != null) {
            Person fetched = personModel.findById(alice.getId());
            System.out.println("Fetched person: " + (fetched != null ? fetched.getName() : "null"));
        }

        // Delete
        if (alice != null && alice.getId() != null) {
            personModel.deleteById(alice.getId());
        }

        System.out.println("Done.");
    }
}
