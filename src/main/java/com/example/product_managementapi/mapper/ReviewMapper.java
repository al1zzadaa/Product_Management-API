package com.example.product_managementapi.mapper;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewResponse reviewToReviewResponse(ReviewEntity reviewEntity);
    ReviewEntity reviewToReviewEntity(ReviewRequest reviewRequest);

    List<ReviewResponse> reviewsToReviewResponses(List<ReviewEntity> reviewEntities);
}
