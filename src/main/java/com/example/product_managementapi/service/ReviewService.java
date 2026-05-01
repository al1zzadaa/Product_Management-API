package com.example.product_managementapi.service;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.entity.ReviewEntity;
import com.example.product_managementapi.exceptions.ReviewException;
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
        if (reviewRequest.getProductId() == null || reviewRequest.getReview() == null) {
            throw new ReviewException("Product Id or Review can't be null");
        }
        ReviewEntity reviewEntity = reviewMapper.reviewToReviewEntity(reviewRequest);
        ReviewEntity createdReviewEntity = reviewRepository.save(reviewEntity);

        return  reviewMapper.reviewToReviewResponse(createdReviewEntity);
    }

    public ReviewResponse getReviewById(Long reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewException("Review Not Found"));
        return reviewMapper.reviewToReviewResponse(reviewEntity);
    }

    public List<ReviewResponse> findReviewsByProductId(Long productId) {
        List<ReviewEntity> reviewEntity = reviewRepository.findReviewsByProductId(productId);
        return reviewMapper.reviewsToReviewResponses(reviewEntity);
    }

    public void deleteReviewById(Long reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
        }
    }
}
