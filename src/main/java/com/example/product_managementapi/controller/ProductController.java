package com.example.product_managementapi.controller;

import com.example.product_managementapi.dto.request.ProductRequestDto;
import com.example.product_managementapi.dto.request.UpdateProductRequestDto;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.dto.response.DiscountedPriceResponse;
import com.example.product_managementapi.enums.ProductStatus;
import com.example.product_managementapi.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @GetMapping("/search")
    public List<ProductResponseDto> getByName(@RequestParam String productName) {
        return productService.findByName(productName);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @GetMapping("/filter")
    public List<ProductResponseDto> getProductsByPrice(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        return productService.filterByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/{id}/discounted-price")
    public DiscountedPriceResponse getPriceWithDiscount(@PathVariable Long id, @RequestParam Integer percent) {
        return productService.getDiscountedPrice(id, percent);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductResponseDto> getProductsByCategoryId(@PathVariable Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequestDto updateProductRequestDto) {
        productService.updateProduct(productId, updateProductRequestDto);
    }

    @GetMapping("/active-category")
    public List<ProductResponseDto> getActiveProductsByCategory(@RequestParam String categoryName, @RequestParam ProductStatus active) {
        return productService.getProductsByCategory(categoryName, active);
    }

}
