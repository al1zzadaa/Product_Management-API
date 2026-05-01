package com.example.product_managementapi.dto.response;

import java.time.LocalDateTime;

public class ReviewResponse {
    private Long reviewId;
    private String reviewContent;
    private LocalDateTime reviewDate;
    private Long productId;

    @Override
    public String toString() {
        return "ReviewResponse{" +
                "reviewId=" + reviewId +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewDate=" + reviewDate +
                ", productId=" + productId +
                '}';
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ReviewResponse(Long reviewId, String reviewContent, LocalDateTime reviewDate, Long productId) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.productId = productId;
    }
}
