package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);

        // save product
        Product savedObject = productRepository.save(product);
        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }

    @Test
    void updateUsingSaveMethod() {
        //retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();
    }

    @Test
    void saveAllMethod() {
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);

        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach(x -> System.out.println(x.getName()));
    }

    @Test
    void deleteByIdMethod() {
        productRepository.deleteById(1L);
    }

    @Test
    void deleteMethod() {
        //find an entity by ID
        Product product = productRepository.findById(2L).get();
        //delete entity
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
//        Product product1 = productRepository.findById(5L).get();
//        Product product2 = productRepository.findById(6L).get();
//        productRepository.deleteAll(List.of(product1, product2));
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        boolean result = productRepository.existsById(10L);
        System.out.println(result);

    }
}