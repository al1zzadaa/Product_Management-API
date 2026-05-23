package com.example.product_managementapi.repository;

import com.example.product_managementapi.entity.ProductEntity;
import com.example.product_managementapi.enums.ProductStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>,
                                            JpaSpecificationExecutor<ProductEntity> {
    List<ProductEntity> findByNameContainingIgnoreCase(String name);

    List<ProductEntity> findByPriceBetween(BigDecimal min, BigDecimal max);


    List<ProductEntity> findByCategoriesId(Long categoryId);

//    @EntityGraph(attributePaths = {"reviews", "categories"})
//    List<ProductEntity> findAll(Specification<ProductEntity> spec);

//    @Query("SELECT DISTINCT p "+
//            " FROM ProductEntity p "+
//            " JOIN p.categories c " +
//            " JOIN p.reviews r " +
//            " WHERE c.name = :categoryName " +
//            " AND p.active = :status ")
//    List<ProductEntity> findActiveProductsByCategoryNameAndActive(String category_name, ProductStatus status);
}
