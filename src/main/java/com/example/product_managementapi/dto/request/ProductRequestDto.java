package com.example.product_managementapi.dto.request;

import com.example.product_managementapi.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductRequestDto {
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Long categoryId;
    private String active;
    private LocalDateTime createDate;

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryId=" + categoryId +
                ", active=" + active +
                ", createDate=" + createDate +
                '}';
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public ProductRequestDto(String productName, String description, BigDecimal price, Integer quantity, Long categoryId, String active) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.active = active.toUpperCase();
        this.createDate = LocalDateTime.now();
    }
}
