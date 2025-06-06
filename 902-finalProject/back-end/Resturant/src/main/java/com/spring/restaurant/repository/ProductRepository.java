package com.spring.restaurant.repository;

import com.spring.restaurant.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByCategoryId(Long id, Pageable pageable);





    @Query(value = "SELECT * FROM Product WHERE LOWER(name) LIKE '%' || LOWER(:val) || '%' OR LOWER(description) LIKE '%' || LOWER(:val) || '%'", nativeQuery = true)
    Page<Product> getProductByLetters(@Param("val") String letters, Pageable pageable);

}
