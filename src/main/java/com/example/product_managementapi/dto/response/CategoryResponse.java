package com.example.product_managementapi.dto.response;

import java.util.List;

public class CategoryResponse {
    private Long categoryId;
    private String categoryName;
    private List<ProductResponseDto> productResponseDtoList;

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", productResponseDtoList=" + productResponseDtoList +
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

    public List<ProductResponseDto> getProductResponseDtoList() {
        return productResponseDtoList;
    }

    public void setProductResponseDtoList(List<ProductResponseDto> productResponseDtoList) {
        this.productResponseDtoList = productResponseDtoList;
    }

    public CategoryResponse(Long categoryId, String categoryName, List<ProductResponseDto> productResponseDtoList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productResponseDtoList = productResponseDtoList;
    }
}
