package com.example.product_managementapi.dto.response;


import java.math.BigDecimal;


public class DiscountedPriceResponse {
    private Long id;
    private String name;
    private BigDecimal finalPrice;
    private Integer discountPercent;
    private BigDecimal originalPrice;

    public DiscountedPriceResponse(Long id,
                                   String name,
                                   BigDecimal finalPrice,
                                   Integer discountPercent,
                                   BigDecimal originalPrice) {
        this.id = id;
        this.name = name;
        this.finalPrice = finalPrice;
        this.discountPercent = discountPercent;
        this.originalPrice = originalPrice;
    }

    @Override
    public String toString() {
        return "DiscountedPriceResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", finalPrice=" + finalPrice +
                ", discountPercent=" + discountPercent +
                ", originalPrice=" + originalPrice +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }
}


