package com.example.product_managementapi.dto.response;


import com.example.product_managementapi.entity.CategoryEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String active;
    private String categories;
    private LocalDateTime createdAt;
    private List<String> allReviews;
    private BigDecimal totalPrice;
    private LocalDateTime updatedAt;


    
}
