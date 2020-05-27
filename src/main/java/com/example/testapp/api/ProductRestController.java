package com.example.testapp.api;

import com.example.testapp.Products.Product;
import com.example.testapp.Products.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/products")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product showNewProductPage(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam Optional<String> query) {
        return new ArrayList<>(query.map(productService::getAllProductsByQuery)
                .orElseGet(productService::getAllProducts));
    }


    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product editProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
