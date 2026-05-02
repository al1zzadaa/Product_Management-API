package com.example.product_managementapi.dto.response;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class ProductResponseDto {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Long categoryId;
    private String active;
    private LocalDateTime createdAt;
    private List<String> allReviews;
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryId=" + categoryId +
                ", active='" + active + '\'' +
                ", createdAt=" + createdAt +
                ", allReviews=" + allReviews +
                ", totalPrice=" + totalPrice +
                '}';
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public ProductResponseDto(Long id, String productName, String description, BigDecimal price, Integer quantity, Long categoryId, String active, LocalDateTime createdAt, List<String> allReviews, BigDecimal totalPrice) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.active = active;
        this.createdAt = createdAt;
        this.allReviews = allReviews;
        this.totalPrice = totalPrice;
    }
}
