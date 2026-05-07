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
    private String active;
    private List<String> categories;
    private LocalDateTime createdAt;
    private List<String> allReviews;
    private BigDecimal totalPrice;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", active='" + active + '\'' +
                ", categories=" + categories +
                ", createdAt=" + createdAt +
                ", allReviews=" + allReviews +
                ", totalPrice=" + totalPrice +
                ", updatedAt=" + updatedAt +
                '}';
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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

    public List<String> getAllReviews() {
        return allReviews;
    }

    public void setAllReviews(List<String> allReviews) {
        this.allReviews = allReviews;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public ProductResponseDto(Long id, String productName, String description, BigDecimal price, Integer quantity, String active, List<String> categories, LocalDateTime createdAt, List<String> allReviews, BigDecimal totalPrice) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
        this.categories = categories;
        this.createdAt = createdAt;
        this.allReviews = allReviews;
        this.totalPrice = totalPrice;
    }
}
