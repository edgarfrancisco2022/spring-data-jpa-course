package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findbyNameOrDescriptionMethod() {
        List<Product> result = productRepository.findByNameOrDescription("product 1", "product 2 description");
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findbyNameAndDescriptionMethod() {
        List<Product> result = productRepository.findByNameAndDescription("product 1", "product 1 description");
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> result = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> result = productRepository.findByPriceLessThan(new BigDecimal(200));
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> result = productRepository.findByNameContaining("product 1");
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> result = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod() {
        LocalDateTime startDate = LocalDateTime.of(2022, 04, 22, 11, 32, 03);
        LocalDateTime endTime = LocalDateTime.of(2022, 04, 22, 11, 45, 10);

        List<Product> result = productRepository.findByDateCreatedBetween(startDate, endTime);

        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findByNameInMethod() {
        List<Product> result = productRepository.findByNameIn(List.of("product 1", "product 2", "product 3"));

        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> result = productRepository.findFirst2ByOrderByNameAsc();
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findTop3ByOrderByPriceDescMethod() {
        List<Product> result = productRepository.findTop3ByOrderByPriceDesc();
        result.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }


}
