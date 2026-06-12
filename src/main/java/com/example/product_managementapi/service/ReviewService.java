package com.example.product_managementapi.service;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.entity.ReviewEntity;
import com.example.product_managementapi.exceptions.NotFoundException;
import com.example.product_managementapi.mapper.ReviewMapper;
import com.example.product_managementapi.repository.ReviewRepository;
import com.example.product_managementapi.utill.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final ValidationUtil validationUtil;


    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper, ValidationUtil validationUtil) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.validationUtil = validationUtil;
    }

    public ReviewResponse createReview(ReviewRequest reviewRequest) {

        validationUtil.validateId(reviewRequest.getProductId());

        validationUtil.validateReview(reviewRequest.getReview());

        ReviewEntity reviewEntity = reviewMapper.reviewToReviewEntity(reviewRequest);
        ReviewEntity createdReviewEntity = reviewRepository.save(reviewEntity);

        return  reviewMapper.reviewToReviewResponse(createdReviewEntity);
    }

    public ReviewResponse getReviewById(Long reviewId) {

        validationUtil.validateId(reviewId);

        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new NotFoundException("Review Not Found"));
        return reviewMapper.reviewToReviewResponse(reviewEntity);
    }

    public Page<ReviewResponse> findReviewsByProductId(Long productId, Pageable pageable) {

        validationUtil.validateId(productId);

        Page<ReviewEntity> reviewEntity = reviewRepository.findReviewsByProductId(productId, pageable);

        return reviewEntity.map(review -> reviewMapper.reviewToReviewResponse(review));
    }

    public void deleteReviewById(Long reviewId) {
        validationUtil.validateId(reviewId);

        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
        }
    }
}
