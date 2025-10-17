package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Products")
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // --- WELCOME ---
    @ApiOperation(value = "WELCOME TO PRODUCT REST API.")
    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME TO PRODUCT REST API.";
    }

    // --- LIST ALL PRODUCTS ---
    @ApiOperation(value = "List all products")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    @GetMapping("/allProducts")
    public List<Product> allProducts() {
        // (No persistence) Simply return current in-memory list
        return repository.getAllProducts();
    }

    // --- FIND BY ID ---
    @ApiOperation(value = "Find product by id")
    @ApiImplicitParam(name = "id", value = "Product ID", required = true, dataType = "long", paramType = "path", example = "1")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    @GetMapping("/findProductById/{id}")
    public Product findProductById(@PathVariable("id") Long id) {
        if (id == null) {
            // Not throwing an HTTP error, as the task focuses on documenting custom codes.
            return null;
        }
        return repository.getProductById(id);
    }

    // --- ADD PRODUCT ---
    @ApiOperation(value = "Add a new product")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@RequestBody Product p) {
        repository.addProduct(p);
        return p;
    }

    // --- UPDATE PRODUCT ---
    @ApiOperation(value = "Update an existing product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    @PutMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product p) {
        repository.updateProduct(p);
        return p;
    }

    // --- REMOVE PRODUCT ---
    @ApiOperation(value = "Remove a product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @DeleteMapping(value = "/removeProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product removeProduct(@RequestBody Product p) {
        repository.removeProduct(p);
        return p;
    }
}
