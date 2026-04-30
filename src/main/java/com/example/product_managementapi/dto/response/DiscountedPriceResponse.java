package com.example.product_managementapi.dto.response;


import java.math.BigDecimal;


public class DiscountedPriceResponse {
    private Long id;
    private String name;
    private BigDecimal originalPrice;
    private Integer discountPercent;
    private BigDecimal discountedPrice;

    public DiscountedPriceResponse(Long id,
                                   String name,
                                   BigDecimal originalPrice,
                                   Integer discountPercent,
                                   BigDecimal discountedPrice) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountPercent = discountPercent;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString() {
        return "DiscountedPriceResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalPrice=" + originalPrice +
                ", discountPercent=" + discountPercent +
                ", discountedPrice=" + discountedPrice +
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


    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
