package com.example.product_managementapi.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ReviewResponse {
    private Long reviewId;
    private String reviewContent;
    private LocalDateTime reviewDate;
    private Long productId;
}
