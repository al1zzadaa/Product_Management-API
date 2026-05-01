package com.example.product_managementapi.mapper;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.web.SortArgumentResolver;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {


    @Mapping(source = "product.id", target ="productId")
    @Mapping(source = "review", target = "reviewContent")
    @Mapping(source = "id", target = "reviewId")
    ReviewResponse reviewToReviewResponse(ReviewEntity reviewEntity);

    @Mapping(source = "productId", target = "product.id")
    ReviewEntity reviewToReviewEntity(ReviewRequest reviewRequest);


    List<ReviewResponse> reviewsToReviewResponses(List<ReviewEntity> reviewEntities);
}
