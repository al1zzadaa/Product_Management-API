package com.example.product_managementapi.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReviewRequest {
    private String review;
    private Long productId;
}
