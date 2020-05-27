package com.example.testapp.Products;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> getAllProductsByQuery(String query) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getBrand().contains(query) ||
                        product.getName().contains(query)
                )
                .collect(toList());
    }

    public Product updateProduct(Long id,Product product) {
        Product byId = getById(id);
        byId.setPrice(product.getPrice());
        byId.setName(product.getName());
        byId.setQuantity(product.getQuantity());
        byId.setBrand(product.getBrand());
        productRepository.save(byId);
        return byId;
    }
}
