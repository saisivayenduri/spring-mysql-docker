package com.spring.data.jpa.repositories;

import com.spring.data.jpa.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
