package com.example.product_managementapi.controller;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{reviewId}")
    public ReviewResponse getReviewById(@PathVariable Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping
    public ReviewResponse createReview(@RequestBody ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReviewById(@PathVariable Long reviewId) {
        reviewService.deleteReviewById(reviewId);
    }

    @GetMapping("/product/{productId}")
    public Page<ReviewResponse> getReviewsByProductId(@PathVariable Long productId,
                                                      @PageableDefault(size = 5) Pageable pageable) {
        return reviewService.findReviewsByProductId(productId, pageable);
    }



}
