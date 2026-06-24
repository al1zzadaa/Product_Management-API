package com.example.product_managementapi.service;
import com.example.product_managementapi.dto.request.CategoryRequest;
import com.example.product_managementapi.dto.response.CategoryResponse;
import com.example.product_managementapi.entity.CategoryEntity;
import com.example.product_managementapi.exceptions.NotFoundException;
import com.example.product_managementapi.mapper.CategoryMapper;
import com.example.product_managementapi.repository.CategoryRepository;
import com.example.product_managementapi.utill.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

        log.info("Method called: {}",id);
        validationUtil.validateId(id);

        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(
                        () -> {
                            log.error("Category with id {} not found", id);
                            return new NotFoundException("Category Not Found");
                        }
                );
        log.info("Method ended: {}",categoryEntity.getName());
        return categoryMapper.toDto(categoryEntity);
    }

    public CategoryResponse createCategory(CategoryRequest categoryRequest){
        log.info("Inside createCategory method");
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryRequest);

        log.info("Category created");
        return categoryMapper.toDto(categoryRepository.save(categoryEntity));
    }

    public void deleteCategoryById(Long id){

        log.info("Inside deleteCategory method");


        validationUtil.validateId(id);

        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            log.info("Category deleted");
        }
    }

    public CategoryResponse getCategoryByName(String name){

        log.info("Inside getCategoryByName method");

        validationUtil.validateName(name);

        CategoryEntity categoryEntity = categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(
                        ()-> {
                                log.error("Category with name {} Not Found", name);
                                return new NotFoundException("Category Not Found");
                            }
                        );

        log.info("Category with name {} found",  name);

        return categoryMapper.toDto(categoryEntity);
    }

    public List<CategoryResponse> findAllCategories() {

        long start = System.currentTimeMillis();

        log.info("Inside findAllCategories method");

        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        log.info("Categories found");

        long end = System.currentTimeMillis();

        log.info("findAllCategories executed in {} ms", (end - start));

        return categoryMapper.toListDto(categoryEntities);
    }

}
