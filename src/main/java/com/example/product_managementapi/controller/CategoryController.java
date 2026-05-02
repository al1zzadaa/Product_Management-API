package com.example.product_managementapi.controller;

import com.example.product_managementapi.dto.request.CategoryRequest;
import com.example.product_managementapi.dto.response.CategoryResponse;
import com.example.product_managementapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getCategoryByName(@RequestParam String name){
        return categoryService.getCategoryByName(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }

}
