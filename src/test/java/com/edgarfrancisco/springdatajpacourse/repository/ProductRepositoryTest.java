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
        Product product1 = new Product();
        product1.setName("product 1");
        product1.setDescription("product 1 description");
        product1.setSku("100ABC");
        product1.setPrice(new BigDecimal(100));
        product1.setActive(true);

        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);

//        Product product3 = new Product();
//        product3.setName("product 3");
//        product3.setDescription("product 3 description");
//        product3.setSku("300ABC");
//        product3.setPrice(new BigDecimal(300));
//        product3.setActive(true);
//
//        Product product4 = new Product();
//        product4.setName("product 4");
//        product4.setDescription("product 4 description");
//        product4.setSku("400ABC");
//        product4.setPrice(new BigDecimal(400));
//        product4.setActive(true);
//
//        Product product5 = new Product();
//        product5.setName("product 5");
//        product5.setDescription("product 5 description");
//        product5.setSku("500ABC");
//        product5.setPrice(new BigDecimal(500));
//        product5.setActive(true);
//
//        Product product6 = new Product();
//        product6.setName("product 6");
//        product6.setDescription("product 6 description");
//        product6.setSku("600ABC");
//        product6.setPrice(new BigDecimal(600));
//        product6.setActive(true);
//
//        Product product7 = new Product();
//        product7.setName("product 7");
//        product7.setDescription("product 7 description");
//        product7.setSku("700ABC");
//        product7.setPrice(new BigDecimal(700));
//        product7.setActive(true);
//
//        Product product8 = new Product();
//        product8.setName("product 8");
//        product8.setDescription("product 8 description");
//        product8.setSku("800ABC");
//        product8.setPrice(new BigDecimal(800));
//        product8.setActive(true);
//
//        Product product9 = new Product();
//        product9.setName("product 9");
//        product9.setDescription("product 9 description");
//        product9.setSku("900ABC");
//        product9.setPrice(new BigDecimal(900));
//        product9.setActive(true);
//
//        Product product10 = new Product();
//        product10.setName("product 10");
//        product10.setDescription("product 10 description");
//        product10.setSku("1000ABC");
//        product10.setPrice(new BigDecimal(1000));
//        product10.setActive(true);
//
//        Product product11 = new Product();
//        product11.setName("product 11");
//        product11.setDescription("product 11 description");
//        product11.setSku("1100ABC");
//        product11.setPrice(new BigDecimal(1100));
//        product11.setActive(true);
//
//        Product product12 = new Product();
//        product12.setName("product 12");
//        product12.setDescription("product 12 description");
//        product12.setSku("1200ABC");
//        product12.setPrice(new BigDecimal(1200));
//        product12.setActive(true);
//
//        Product product13 = new Product();
//        product13.setName("product 13");
//        product13.setDescription("product 13 description");
//        product13.setSku("1300ABC");
//        product13.setPrice(new BigDecimal(1300));
//        product13.setActive(true);
//
//        Product product14 = new Product();
//        product14.setName("product 14");
//        product14.setDescription("product 14 description");
//        product14.setSku("1400ABC");
//        product14.setPrice(new BigDecimal(1400));
//        product14.setActive(true);
//
//        Product product15 = new Product();
//        product15.setName("product 15");
//        product15.setDescription("product 15 description");
//        product15.setSku("1500ABC");
//        product15.setPrice(new BigDecimal(1500));
//        product15.setActive(true);

        productRepository.saveAll(List.of(product1, product2/*, product3, product4, product5,
                                          product6, product7, product8, product9, product10,
                                          product11, product12, product13, product14, product15*/));
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