package com.example.product_managementapi.dto.request;

public class CategoryRequest {
    private String categoryName;
    private Long productId;

    public CategoryRequest(String categoryName, Long productId) {
        this.categoryName = categoryName;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "categoryName='" + categoryName + '\'' +
                ", productId=" + productId +
                '}';
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
}
