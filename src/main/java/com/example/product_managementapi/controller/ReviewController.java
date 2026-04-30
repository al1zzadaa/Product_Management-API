package com.example.product_managementapi.controller;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewResponse> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping("/{reviewId}")
    public ReviewResponse getReviewById(@PathVariable Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping
    public ReviewResponse createReview(@RequestBody ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }

    @GetMapping("/{productId}/product")
    public List<ReviewResponse> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.findReviewsByProductId(productId);
    }
}
