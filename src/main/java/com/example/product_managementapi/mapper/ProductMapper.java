package com.example.product_managementapi.mapper;

import com.example.product_managementapi.dto.request.ProductRequestDto;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.dto.request.UpdateProductRequestDto;
import com.example.product_managementapi.entity.CategoryEntity;
import com.example.product_managementapi.entity.ProductEntity;
import com.example.product_managementapi.entity.ReviewEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "productName", target = "name")
    ProductEntity productToProductEntity(ProductRequestDto productRequest);


    @Mapping(target = "totalPrice",
            expression = "java(productEntity.getPrice().multiply(BigDecimal.valueOf(productEntity.getQuantity())))")
    @Mapping(source = "name", target = "productName")
//    @Mapping(target = "allReviews",
//            expression = "java(productEntity.getReviews().stream().map(ReviewEntity :: getReviews).toList())")
    @Mapping(source = "reviews", target = "allReviews")
    ProductResponseDto productEntityToProduct(ProductEntity productEntity);


    default String map(CategoryEntity category) {
        return category.getName();
    }

    default String map(ReviewEntity review) {
        return review.getReview();
    }

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProduct(UpdateProductRequestDto updateProductRequestDto, @MappingTarget ProductEntity productEntity);


    List<ProductResponseDto> productEntitiesToProduct(List<ProductEntity> entities);
}
