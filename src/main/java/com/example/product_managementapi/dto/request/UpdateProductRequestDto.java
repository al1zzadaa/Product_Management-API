package com.example.product_managementapi.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String active;
}
