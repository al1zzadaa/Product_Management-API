package com.example.product_managementapi.dto.request;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private List<Long> categoryIds;
    private String active;
    private LocalDateTime createDate;
}
