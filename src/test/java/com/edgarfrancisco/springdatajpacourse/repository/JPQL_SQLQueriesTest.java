package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQL_SQLQueriesTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod() {
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("product 1", "product 4 description");
        System.out.println(product.getId());
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParametersMethod() {
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParameters("product 2", "product 2 description");
        System.out.println(product.getId());
    }

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod() {
        Product product = productRepository.findByNameOrDescriptionSQLIndexParam("edgar", "product 1 description");
        System.out.println(product.getId() + " " + product.getName());
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod() {
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("edgar", "product 1 description");
        System.out.println(product.getId() + " " + product.getName());
    }
}
