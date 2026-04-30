package com.example.product_managementapi.mapper;

import com.example.product_managementapi.dto.request.CategoryRequest;
import com.example.product_managementapi.dto.response.CategoryResponse;
import com.example.product_managementapi.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "id", target = "productId")
    CategoryResponse toDto(CategoryEntity categoryEntity);
    @Mapping(source = "productId", target = "productId.id")
    CategoryEntity toEntity(CategoryRequest categoryRequest);

    List<CategoryResponse> toListDto(List<CategoryEntity> categoryEntities);

}
