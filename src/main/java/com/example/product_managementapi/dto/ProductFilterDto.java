package com.example.product_managementapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterDto {
    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private LocalDate fromDate;
    private LocalDate toDate;
    private ReviewFilterDto reviewFilterDto;
//    private List<String> category;
}
