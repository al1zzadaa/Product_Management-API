package com.example.product_managementapi.mapper;

import com.example.product_managementapi.dto.request.ProductRequestDto;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.dto.request.UpdateProductRequestDto;
import com.example.product_managementapi.entity.ProductEntity;
import com.example.product_managementapi.entity.ReviewEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "productName", target = "name")
    @Mapping(source = "categoryId", target = "category.id")
    ProductEntity productToProductEntity(ProductRequestDto productRequest);

    @Mapping(target = "totalPrice",
            expression = "java(productEntity.getPrice().multiply(BigDecimal.valueOf(productEntity.getQuantity())))")
    @Mapping(source = "name", target = "productName")
//    @Mapping(source = "category.id", target = "categoryResponse.categoryId")
//    @Mapping(source = "category.name", target = "categoryResponse.categoryName")
//    @Mapping(source = "category.products", target = "categoryResponse.productResponseDtoList")
    @Mapping(source = "reviews", target = "allReviews")
    @Mapping(source = "category.id", target = "categoryId")
    ProductResponseDto productEntityToProduct(ProductEntity productEntity);

    default String map(ReviewEntity review) {
        return review.getReview();
    }


    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "categoryId", target = "category.id")
    void updateProduct(UpdateProductRequestDto updateProductRequestDto, @MappingTarget ProductEntity productEntity);

    List<ProductResponseDto> productEntitiesToProduct(List<ProductEntity> entities);
}
