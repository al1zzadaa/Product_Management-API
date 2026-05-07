package com.example.product_managementapi.mapper;

import com.example.product_managementapi.dto.request.CategoryRequest;
import com.example.product_managementapi.dto.response.CategoryResponse;
import com.example.product_managementapi.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// uses = ProductMapper.class we need to write this
//because without this one toDto() method
//products cant be mapped to productResponseDtoList
@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CategoryMapper {

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    @Mapping(source = "products", target = "productResponseDtoList")
    CategoryResponse toDto(CategoryEntity categoryEntity);


    @Mapping(source = "categoryName", target = "name")
    CategoryEntity toEntity(CategoryRequest categoryRequest);

    List<CategoryResponse> toListDto(List<CategoryEntity> categoryEntities);

}
