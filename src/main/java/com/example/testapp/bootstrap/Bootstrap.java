package com.example.testapp.bootstrap;

import com.example.testapp.Products.Product;
import com.example.testapp.Products.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bootstrap implements CommandLineRunner {
    private ProductService productService;

    public Bootstrap(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setName("Iphone SE");
        product.setBrand("Apple");
        product.setQuantity(1);
        product.setPrice(2300f);


        Product product1 = new Product();
        product1.setName("S10");
        product1.setBrand("Samsung");
        product1.setQuantity(4);
        product1.setPrice(2500.30f);

        Product product2 = new Product();
        product2.setName("Iphone 10");
        product2.setBrand("Apple");
        product2.setQuantity(12);
        product2.setPrice(3400f);

        productService.save(product);
        productService.save(product1);
        productService.save(product2);

    }
}
