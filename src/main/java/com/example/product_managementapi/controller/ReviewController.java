package com.example.product_managementapi.controller;

import com.example.product_managementapi.dto.request.ReviewRequest;
import com.example.product_managementapi.dto.response.ReviewResponse;
import com.example.product_managementapi.service.ReviewService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse getReviewById(@PathVariable Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@RequestBody ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }

    @DeleteMapping("/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReviewById(@PathVariable Long reviewId) {
        reviewService.deleteReviewById(reviewId);
    }

    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.findReviewsByProductId(productId);
    }
}
