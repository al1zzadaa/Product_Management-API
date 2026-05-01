package com.example.product_managementapi.service;
import com.example.product_managementapi.dto.request.CategoryRequest;
import com.example.product_managementapi.dto.response.CategoryResponse;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.entity.CategoryEntity;
import com.example.product_managementapi.entity.ProductEntity;
import com.example.product_managementapi.exceptions.CategoryException;
import com.example.product_managementapi.exceptions.IdException;
import com.example.product_managementapi.mapper.CategoryMapper;
import com.example.product_managementapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
//    private final ProductService productService;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
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

    public void deleteCategoryById(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }
    }

    public CategoryResponse getCategoryByName(String name){
        CategoryEntity categoryEntity = categoryRepository.findByName(name)
                .orElseThrow(()-> new CategoryException("Category Not Found"));
        return categoryMapper.toDto(categoryEntity);
    }

    public List<CategoryResponse> findAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryMapper.toListDto(categoryEntities);
    }

//    public List<ProductResponseDto> getProductsByCategory(String category) {
//        if(category == null || category.isBlank()){
//            throw new CategoryException("Category Not Found");
//        }
//
//        List<CategoryEntity> categoryEntities = findAllCategories()
//                .stream()
//                .filter(catg -> catg.getCategoryName().equals(category))
//                .map(fff -> categoryMapper.toDto(fff));
//
//
//        List<ProductEntity> productEntities = productService.getProducts()
//                .stream()
//                .filter(product -> product.getCategoryId() == )
//                .map()
//
//    }
}
