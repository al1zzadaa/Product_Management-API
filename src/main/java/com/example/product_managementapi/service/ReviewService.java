package com.example.product_managementapi.service;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.entity.ReviewEntity;
import com.example.product_managementapi.exceptions.IdException;
import com.example.product_managementapi.mapper.ReviewMapper;
import com.example.product_managementapi.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public ReviewResponse createReview(ReviewRequest reviewRequest) {
        ReviewEntity reviewEntity = reviewMapper.reviewToReviewEntity(reviewRequest);
        return  reviewMapper.reviewToReviewResponse(reviewRepository.save(reviewEntity));
    }

    public List<ReviewResponse> getReviews() {
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();
        return reviewMapper.reviewsToReviewResponses(reviewEntities);
    }

    public ReviewResponse getReviewById(Long reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IdException("Review Not Found"));
        return reviewMapper.reviewToReviewResponse(reviewEntity);
    }

    public List<ReviewResponse> findReviewsByProductId(Long productId) {
        List<ReviewEntity> reviewEntity = reviewRepository.findReviewsByProductId(productId);
        return reviewMapper.reviewsToReviewResponses(reviewEntity);
    }
}
