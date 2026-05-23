package com.example.product_managementapi.service.specification;

import com.example.product_managementapi.dto.ProductFilterDto;
import com.example.product_managementapi.dto.ReviewFilterDto;
import com.example.product_managementapi.entity.ProductEntity;
import com.example.product_managementapi.entity.ReviewEntity;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecification implements Specification<ProductEntity> {

    private ProductFilterDto productFilterDto;

    @Override
    public @Nullable Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if (productFilterDto == null) {
            return null;
        }

        List<Predicate> predicates = new ArrayList<>();

        if (productFilterDto.getName() != null && !productFilterDto.getName().isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("name").as(String.class), productFilterDto.getName() + "%"));
            System.out.println("aaa");
        }

        if (productFilterDto.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price").as(BigDecimal.class), productFilterDto.getMinPrice())) ;
        }

        if (productFilterDto.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price").as(BigDecimal.class), productFilterDto.getMaxPrice())) ;
        }

//        if (productFilterDto.getCategory() != null) {
//            List<String> categories = productFilterDto.getCategory();
//            predicates.add(root.get("categories").in(categories));
//        }

        if (productFilterDto.getFromDate() != null ) {
            LocalDate fromDate = productFilterDto.getFromDate();
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt").as(LocalDate.class), fromDate)) ;
        }

        if (productFilterDto.getToDate() != null) {
            LocalDate toDate = productFilterDto.getToDate();
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt").as(LocalDate.class), toDate)) ;
        }

        if (productFilterDto.getReviewFilterDto() != null) {

            var reviewFilterDto = productFilterDto.getReviewFilterDto();

            Join<ProductEntity, ReviewEntity> reviewJoin =
                    root.join("reviews", JoinType.INNER);

            if (reviewFilterDto.getFromReviewDate() != null) {

                LocalDate fromReviewDate = reviewFilterDto.getFromReviewDate();
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(
                                reviewJoin.get("reviewDate"),
                                fromReviewDate
                        )
                );
            }

            if (reviewFilterDto.getToReviewDate() != null) {

                LocalDate toReviewDate = reviewFilterDto.getToReviewDate();
                predicates.add(
                        criteriaBuilder.lessThanOrEqualTo(
                                reviewJoin.get("reviewDate"),
                                toReviewDate
                        )
                );
            }
        }
        query.distinct(true);

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
