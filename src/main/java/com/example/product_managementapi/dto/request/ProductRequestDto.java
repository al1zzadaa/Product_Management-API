package com.example.product_managementapi.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Product name", example = "IPhone")
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;
    private String active;
    private LocalDateTime createDate;
}
