package com.example.product_managementapi.utill;

import com.example.product_managementapi.enums.ProductStatus;
import com.example.product_managementapi.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ValidationUtil{

    public  void validateId(Long id){
        if(id == null|| id <= 0) {
            throw new ValidationException("Invalid ID");
        }
    }

    public  void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException("Name cannot be null or blank");
        }
    }

    public  void validatePrice(BigDecimal price) {
        if (price == null || price.doubleValue() < 0) {
            throw new ValidationException("Price cannot be negative");
        }
    }

    public  void validatePercent(Integer percent) {
        if (percent == null || percent <= 0 || percent > 100) {
            throw new ValidationException("Percent cannot be negative");
        }
    }

    public  void validateStatus(ProductStatus status) {
        if (status == null) {
            throw new ValidationException("Status cannot be null or blank");
        }
    }

    public  void validateReview(String review) {
        if (review == null || review.isBlank()) {
            throw new ValidationException("Review cannot be null or blank");
        }
    }
}