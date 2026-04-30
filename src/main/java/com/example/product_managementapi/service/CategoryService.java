package com.example.product_managementapi.service;
import com.example.product_managementapi.dto.request.CategoryRequest;
import com.example.product_managementapi.dto.response.CategoryResponse;
import com.example.product_managementapi.entity.CategoryEntity;
import com.example.product_managementapi.exceptions.IdException;
import com.example.product_managementapi.mapper.CategoryMapper;
import com.example.product_managementapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponse> getCategories(){
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
       return categoryMapper.toListDto(categoryEntities);
    }

    public CategoryResponse getCategoryById(Long id){
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new IdException("Category Not Found"));
        return categoryMapper.toDto(categoryEntity);
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest){
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryRequest);
        return categoryMapper.toDto(categoryRepository.save(categoryEntity));
    }
}
