package com.example.product_managementapi.dto.response;


import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class DiscountedPriceResponse {
    private Long id;
    private String name;
    private BigDecimal finalPrice;
    private Integer discountPercent;
    private BigDecimal originalPrice;
}


