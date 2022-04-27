package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
