package com.example.product_managementapi.mapper;

import com.example.product_managementapi.dto.request.ProductRequestDto;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.dto.request.UpdateProductRequestDto;
import com.example.product_managementapi.entity.ProductEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity productToProductEntity(ProductRequestDto productRequest);

    @Mapping(target = "totalPrice",
            expression = "java(productEntity.getPrice().multiply(BigDecimal.valueOf(productEntity.getQuantity())))")
    @Mapping(source = "category.name", target = "categoryName")
    ProductResponseDto productEntityToProduct(ProductEntity productEntity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "category", target = "category.name")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProduct(UpdateProductRequestDto updateProductRequestDto, @MappingTarget ProductEntity productEntity);


    List<ProductResponseDto> productEntitiesToProduct(List<ProductEntity> entities);
}
