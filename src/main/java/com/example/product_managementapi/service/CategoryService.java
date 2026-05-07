package com.example.product_managementapi.service;
import com.example.product_managementapi.dto.request.CategoryRequest;
import com.example.product_managementapi.dto.response.CategoryResponse;
import com.example.product_managementapi.entity.CategoryEntity;
import com.example.product_managementapi.exceptions.NotFoundException;
import com.example.product_managementapi.mapper.CategoryMapper;
import com.example.product_managementapi.repository.CategoryRepository;
import com.example.product_managementapi.utill.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ValidationUtil validationUtil;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper, ValidationUtil validationUtil, ValidationUtil validationUtil1) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.validationUtil = validationUtil1;
    }

    public CategoryResponse getCategoryById(Long id){

        validationUtil.validateId(id);

        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category Not Found"));
        return categoryMapper.toDto(categoryEntity);
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest){
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryRequest);
        return categoryMapper.toDto(categoryRepository.save(categoryEntity));
    }

    public void deleteCategoryById(Long id){

        validationUtil.validateId(id);

        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }
    }

    public CategoryResponse getCategoryByName(String name){

        validationUtil.validateName(name);

        CategoryEntity categoryEntity = categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(()-> new NotFoundException("Category Not Found"));
        return categoryMapper.toDto(categoryEntity);
    }

    public List<CategoryResponse> findAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        return categoryMapper.toListDto(categoryEntities);
    }
}
