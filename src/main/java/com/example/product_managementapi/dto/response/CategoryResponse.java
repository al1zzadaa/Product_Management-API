package com.example.product_managementapi.dto.response;

import lombok.*;

import java.util.List;


@ToString
@Getter
@Setter
@AllArgsConstructor
public class CategoryResponse {
    private Long categoryId;
    private String categoryName;
    private List<ProductResponseDto> productResponseDtoList;
}
