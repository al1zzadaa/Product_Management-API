package com.example.product_managementapi.dto.request;

import java.time.LocalDateTime;

public class ReviewRequest {
    private String review;
    private Long productId;
    private LocalDateTime reviewDate;

    @Override
    public String toString() {
        return "ReviewRequest{" +
                "review='" + review + '\'' +
                ", productId=" + productId +
                ", reviewDate=" + reviewDate +
                '}';
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public ReviewRequest(String review, Long productId) {
        this.review = review;
        this.productId = productId;
        this.reviewDate = LocalDateTime.now();
    }
}
