package com.example.testapp.Products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService = new ProductService();

    @Test
    public void testSaveProduct() {

        //given
        Product product1 = new Product(1L, "name", "brand", 2, 22.2F);

        //when
        Product p = productService.save(product1);

        //then
        assertEquals("name", p.getName());
    }

    @Test
    public void testSaveProductDifferentMethod() {

        //given
        Product product1 = new Product(1L, "name", "brand", 2, 22.2F);

        //when
        Product p = productService.save(product1);

        //then
        ArgumentCaptor<Product> argumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(argumentCaptor.capture());
        Product value = argumentCaptor.getValue();
        assertEquals("brand", value.getBrand());
    }

    @Test
    public void testGetProducts() {

        //given
        Product product1 = new Product(1L, "name", "brand", 2, 22.2F);
        Product product2 = new Product(2L, "name2", "brand2", 2, 222F);

        //when
        ArrayList<Product> products = new ArrayList<>();
        products.add(productService.save(product1));
        products.add(productService.save(product2));

        //then
        assertEquals(2, products.size());
    }
}
