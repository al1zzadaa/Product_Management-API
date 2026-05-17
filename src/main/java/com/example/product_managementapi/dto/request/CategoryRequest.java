package com.example.product_managementapi.dto.request;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class CategoryRequest {
    private String categoryName;
}
