package com.example.product_managementapi.repository;

import com.example.product_managementapi.entity.CategoryEntity;
import com.example.product_managementapi.entity.ProductEntity;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByNameContainingIgnoreCase(String name);
    List<ProductEntity> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<ProductEntity> findByCategoryId(Long categoryId);
}
