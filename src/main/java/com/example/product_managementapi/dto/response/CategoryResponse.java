package com.example.product_managementapi.dto.response;

public class CategoryResponse {
    private Long categoryId;
    private String categoryName;
    private Long productId;
    private String productName;

    public CategoryResponse(Long categoryId, String categoryName, Long productId, String productName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
