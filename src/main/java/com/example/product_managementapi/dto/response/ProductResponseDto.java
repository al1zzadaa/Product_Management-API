package com.example.product_managementapi.dto.response;


import com.example.product_managementapi.entity.CategoryEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class ProductResponseDto {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String categoryName;
    private String active;
    private LocalDateTime createdAt;
    private List<String> reviews;
    private BigDecimal totalPrice;


    public ProductResponseDto(Long id,
                              String productName,
                              String description,
                              BigDecimal price,
                              Integer quantity,
                              String categoryName,
                              String active,
                              LocalDateTime createdAt,
                              List<String> reviews,
                              BigDecimal totalPrice) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.active = active;
        this.createdAt = createdAt;
        this.reviews = reviews;
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
}
