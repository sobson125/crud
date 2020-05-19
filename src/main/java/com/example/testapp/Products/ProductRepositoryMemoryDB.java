package com.example.testapp.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryMemoryDB extends JpaRepository<Product,Long>,ProductRepository{

}
