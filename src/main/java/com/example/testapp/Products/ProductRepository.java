package com.example.testapp.Products;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Product save(Product product);
    void deleteById(Long id);
    Optional<Product> findById(Long id);
}
