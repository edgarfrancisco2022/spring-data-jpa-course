package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void pagination() {
        int pageNo = 0;
        int pageSize = 5;

        //create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);

        //Get all the products with the getContent() method
        List<Product> products = page.getContent();
        products.forEach((p) -> {
            System.out.println(p);
        });

        //total pages
        int totalPages = page.getTotalPages();
        //total elements
        long totalElements = page.getTotalElements();
        //number of elements
        int numberOfElements = page.getNumberOfElements();
        //size
        int size = page.getSize();
        //last
        boolean isLast = page.isLast();
        //first
        boolean isFirst = page.isFirst();

        System.out.println("Total pages -> " + totalPages);
        System.out.println("Total elements -> " + totalElements);
        System.out.println("Number of elements -> " + numberOfElements);
        System.out.println("Size -> " + size);
        System.out.println("isLast = " + isLast);
        System.out.println("isFirst = " + isFirst);
    }

    @Test
    void sorting() {
        String sortBy = "price";
        String orderBy = "desc";
        Sort sort = orderBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                                             Sort.by(sortBy).descending();
        //List<Product> products = productRepository.findAll(Sort.by(sortBy).descending());
        List<Product> products = productRepository.findAll(sort);
        products.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void sortingByMultipleFields() {
        String sortByName = "name";
        String sortByDescription = "description";
        String orderBy = "desc";

        //create to Sort instances
        Sort sortByNameSort = orderBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                          Sort.by(sortByName).ascending() : Sort.by(sortByName).descending();

        Sort sortByDescriptionSort = orderBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                                     Sort.by(sortByDescription).ascending() : Sort.by(sortByDescription).descending();

        Sort sortByGroups = sortByNameSort.and(sortByDescriptionSort);

        List<Product> products = productRepository.findAll(sortByGroups);
        products.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void paginationAndSortingTogether() {
        String sortBy = "price";
        String sortDir = "desc";
        int pageNo = 1;
        int pageSize = 5;

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> products = page.getContent();

        products.forEach((p) -> {
            System.out.println(p);
        });

        //total pages
        int totalPages = page.getTotalPages();
        //total elements
        long totalElements = page.getTotalElements();
        //number of elements
        int numberOfElements = page.getNumberOfElements();
        //size
        int size = page.getSize();
        //last
        boolean isLast = page.isLast();
        //first
        boolean isFirst = page.isFirst();

        System.out.println("Total pages -> " + totalPages);
        System.out.println("Total elements -> " + totalElements);
        System.out.println("Number of elements -> " + numberOfElements);
        System.out.println("Size -> " + size);
        System.out.println("isLast = " + isLast);
        System.out.println("isFirst = " + isFirst);
    }
}
