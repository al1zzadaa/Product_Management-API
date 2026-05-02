package com.example.product_managementapi.repository;
import com.example.product_managementapi.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findReviewsByProductId(Long productId);
}
