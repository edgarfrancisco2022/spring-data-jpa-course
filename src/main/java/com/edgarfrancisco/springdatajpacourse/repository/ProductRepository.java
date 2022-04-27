package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Returns the found product entry by using its name as search criteria.
     * If not product is found, this method returns null
     */
    Product findByName(String name);
    //Optional<Product> findById(Long id);
    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name); //también puede ser findByNameLike

    List<Product> findByPriceBetween(BigDecimal low, BigDecimal high);

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop3ByOrderByPriceDesc();

    //Methods with @Query annotation
    //JPQL query with indexed parameters
    @Query("SELECT p FROM Product p where p.name = ?1 or p.description = ?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);

    //JPQL query with named parameters
    @Query("SELECT p FROM Product p where p.name = :name or p.description = :description")
    Product findByNameOrDescriptionJPQLNamedParameters(@Param("name") String name,
                                                       @Param("description") String description);

    //SQL query with indexed parameters
    @Query(value = "SELECT * FROM products WHERE name = ?1 or description = ?2", nativeQuery = true)
    Product findByNameOrDescriptionSQLIndexParam(String name, String description);

    //SQL query with named parameters
    @Query(value = "SELECT * FROM products WHERE name = :name or description = :description", nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name, @Param("description") String description);

    //Define named JPQL queries
    Product findByPrice(@Param("price") BigDecimal price);

    List<Product> findAllOrderByNameDesc();

    //Define named native SQL queries
    @Query(nativeQuery = true)
    Product findByDescription(@Param("description") String description);

    List<Product> findAllOrderByNameASC();
}
