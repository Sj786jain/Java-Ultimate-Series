package com.sanket.day7_product_inventory_api.repository;

import com.sanket.day7_product_inventory_api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    Page<Product> findByCategoryIgnoreCase(String category, Pageable pageable);
    List<Product> findByQuantityLessThanEqual(Integer threshold);
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);


}
