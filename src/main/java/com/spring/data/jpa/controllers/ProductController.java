package com.spring.data.jpa.controllers;

import com.spring.data.jpa.entities.Product;
import com.spring.data.jpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("products/insert")
    public void createProduct() {
        Product product = new Product();
        product.setId(101);
        product.setName("Apple");
        product.setDesc("Iphone");
        product.setPrice(75000.00);
        System.out.println("Saving product " + product);
        productRepository.save(product);

        Product product2 = new Product();
        product2.setId(102);
        product2.setName("keyboard");
        product2.setDesc("logitech keyboard - wireless");
        product2.setPrice(800.00);
        System.out.println("Saving product " + product2);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setId(103);
        product3.setName("Mouse");
        product3.setDesc("logitech mouse - wireless");
        product3.setPrice(550.00);
        System.out.println("Saving product " + product3);
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setId(104);
        product4.setName("USB Converter");
        product4.setDesc("Type A to C Converter");
        product4.setPrice(120.00);
        System.out.println("Saving product " + product4);
        productRepository.save(product4);
    }

    @GetMapping("products/findAll")
    public List<Product> getProducts() {
        ArrayList<Product> productsList = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        for ( Product product : products) {
            productsList.add(product);
        }
        return productsList;
    }

    @GetMapping("products/getById/{id}")
    public Product getProductById(@PathVariable int id) {
        Optional<Product> record = productRepository.findById(id);
        Product product = null;
        if (record.isPresent()) {
            product = record.get();
        }
        return product;
    }

    @PutMapping("products/update/{id}/{price}")
    public String updateProduct(@PathVariable("id") int id, @PathVariable("price") double price) {
        Product updatedProduct = null;
        Optional<Product> product = productRepository.findById(id);
        if ( product.isPresent() ) {
            updatedProduct = product.get();
            if (price > 0) {
                updatedProduct.setPrice(price);
            }
            productRepository.save(updatedProduct);
        }
        return "Product updated Successfully...";
    }
}
