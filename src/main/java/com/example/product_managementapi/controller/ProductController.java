package com.example.product_managementapi.controller;

import com.example.product_managementapi.dto.ProductFilterDto;
import com.example.product_managementapi.dto.request.ProductRequestDto;
import com.example.product_managementapi.dto.request.UpdateProductRequestDto;
import com.example.product_managementapi.dto.response.DiscountedPriceResponse;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.service.ProductService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Products", description = "Product management API")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts(ProductFilterDto productFilterDto) {
        return productService.getProducts(productFilterDto);
    }

    @Hidden
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @GetMapping("/search")
    public List<ProductResponseDto> getByName(@RequestParam String productName) {
        return productService.findByName(productName);
    }

    @Operation(summary = "Get product by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "400", description = "Invalid id")
    })
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@Parameter(description = "Product ID")
                                                 @PathVariable Long id) {
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

//    @GetMapping("/active-category")
//    public List<ProductResponseDto> getActiveProductsByCategory(@RequestParam String categoryName, @RequestParam ProductStatus active) {
//        return productService.getProductsByCategory(categoryName, active);
//    }

}
