package com.example.product_managementapi.dto.request;

public class CategoryRequest {
    private String categoryName;

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryRequest(String categoryName) {
        this.categoryName = categoryName;
    }
}
