package com.example.product_managementapi.dto.response;

import java.time.LocalDateTime;

public class ReviewResponse {
    private Integer reviewId;
    private String reviewContent;
    private LocalDateTime reviewDate;
    private Integer productId;

    public ReviewResponse(Integer reviewId, String reviewContent, LocalDateTime reviewDate, Integer productId) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ReviewResponse{" +
                "reviewId=" + reviewId +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewDate=" + reviewDate +
                ", productId=" + productId +
                '}';
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
