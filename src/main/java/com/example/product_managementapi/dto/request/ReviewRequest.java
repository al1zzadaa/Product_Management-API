package com.example.product_managementapi.dto.request;

import java.time.LocalDateTime;

public class ReviewRequest {
    private String review;
    private Integer productId;
    private LocalDateTime reviewDate;

    @Override
    public String toString() {
        return "ReviewRequest{" +
                "review='" + review + '\'' +
                ", productId=" + productId +
                ", reviewDate=" + reviewDate +
                '}';
    }

    public ReviewRequest(String review, Integer productId) {
        this.review = review;
        this.productId = productId;
        this.reviewDate = LocalDateTime.now();
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
}
