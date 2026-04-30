package com.example.product_managementapi.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdateProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;
    private String active;
    private LocalDateTime updateDate;


    public UpdateProductRequestDto(String name, String description, BigDecimal price, Integer quantity, String category, String active) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.active = active;
        this.updateDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "UpdateProductRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", active='" + active + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
