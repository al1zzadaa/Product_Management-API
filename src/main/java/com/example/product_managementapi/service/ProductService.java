package com.example.product_managementapi.service;

import com.example.product_managementapi.dto.request.UpdateProductRequestDto;
import com.example.product_managementapi.dto.response.DiscountedPriceResponse;
import com.example.product_managementapi.dto.request.ProductRequestDto;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.entity.CategoryEntity;
import com.example.product_managementapi.entity.ProductEntity;
import com.example.product_managementapi.exceptions.*;
import com.example.product_managementapi.mapper.ProductMapper;
import com.example.product_managementapi.repository.CategoryRepository;
import com.example.product_managementapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequest) {

        CategoryEntity category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(()-> new CategoryException("Category Not Found"));

        if(productRequest.getProductName()==null || productRequest.getProductName().isBlank()){
            throw new ProductException("Product name is empty");
        }
        ProductEntity productEntity = productMapper.productToProductEntity(productRequest);

        productEntity.setCategory(category);

        ProductEntity savedProduct = productRepository.save(productEntity);

        return productMapper.productEntityToProduct(savedProduct);
    }

    public void deleteProduct(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new IdException("Product with id " + id + " not found");
        }
    }

    public ProductResponseDto getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new IdException("Product wit id " + id + " not exists"));

        ProductResponseDto productResponseDto = productMapper.productEntityToProduct(productEntity);
        return productResponseDto;
    }

    public List<ProductResponseDto> getProducts() {


        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = productMapper.productEntitiesToProduct(productEntities);

        return productResponseDtos;
    }

    public void updateProduct(Long id, UpdateProductRequestDto updateProductRequestDto) {

        if (updateProductRequestDto.getName()==null || updateProductRequestDto.getName().isBlank()) {
            throw new ProductException("Product name is empty");
        }
        ProductEntity prod = productRepository.findById(id)
                .orElseThrow(() -> new IdException("Product with id " + id + " not found"));

        productMapper.updateProduct(updateProductRequestDto, prod);

        productRepository.save(prod);
    }


    public DiscountedPriceResponse getDiscountedPrice(Long id, Integer percent) {
        if(percent == null){
           throw new PercentException("Percent is empty");
        }
        ProductEntity prod = productRepository.findById(id)
                .orElseThrow(() -> new IdException("Product with id " + id + " not found"));

        BigDecimal price = prod.getPrice();
        BigDecimal discount = price
                .multiply(BigDecimal.valueOf(percent))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        BigDecimal discountedPrice = price.subtract(discount);

        return new DiscountedPriceResponse(
                prod.getId(),
                prod.getName(),
                discountedPrice,
                percent,
                price
        );
    }

    public List<ProductResponseDto> findByName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new NameException("Product's name is empty");
        }

        List<ProductEntity> productEntity = productRepository.findByNameContainingIgnoreCase(productName);

        return productEntity.stream().map(product ->
                        productMapper.productEntityToProduct(product))
                .toList();
    }

    public List<ProductResponseDto> filterByPriceBetween(BigDecimal min, BigDecimal max) {
        List<ProductEntity> productEntities = productRepository.findByPriceBetween(min, max);

        return productEntities.stream().map(product ->
                        productMapper.productEntityToProduct(product))
                .toList();
    }


    public List<ProductResponseDto> getProductsByCategoryId(Long categoryId) {
        List<ProductEntity> productEntities = productRepository.findByCategoryId(categoryId);
        return productMapper.productEntitiesToProduct(productEntities);
    }
}
