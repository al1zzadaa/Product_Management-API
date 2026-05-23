package com.example.product_managementapi.service;

import com.example.product_managementapi.dto.ProductFilterDto;
import com.example.product_managementapi.dto.request.UpdateProductRequestDto;
import com.example.product_managementapi.dto.response.DiscountedPriceResponse;
import com.example.product_managementapi.dto.request.ProductRequestDto;
import com.example.product_managementapi.dto.response.ProductResponseDto;
import com.example.product_managementapi.entity.ProductEntity;
import com.example.product_managementapi.enums.ProductStatus;
import com.example.product_managementapi.exceptions.*;
import com.example.product_managementapi.mapper.ProductMapper;
import com.example.product_managementapi.repository.ProductRepository;
import com.example.product_managementapi.service.specification.ProductSpecification;
import com.example.product_managementapi.utill.ValidationUtil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ValidationUtil validationUtil;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.validationUtil = validationUtil;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequest) {

        validationUtil.validateName(productRequest.getProductName());

        ProductEntity productEntity = productMapper.productToProductEntity(productRequest);

        ProductEntity savedProduct = productRepository.save(productEntity);

        return productMapper.productEntityToProduct(savedProduct);
    }

    public void deleteProduct(Long id) {

        validationUtil.validateId(id);

        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new NotFoundException("Product with id " + id + " not found");
        }
    }

    public ProductResponseDto getProductById(Long id) {

        validationUtil.validateId(id);

        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product wit id " + id + " not exists"));

        ProductResponseDto productResponseDto = productMapper.productEntityToProduct(productEntity);
        return productResponseDto;
    }

    public List<ProductResponseDto> getProducts(ProductFilterDto productFilterDto) {

        var specification = Specification.where(new ProductSpecification(productFilterDto));

        List<ProductEntity> productEntities = productRepository.findAll(specification);

        return productMapper.productEntitiesToProduct(productEntities);
    }

    public void updateProduct(Long id, UpdateProductRequestDto updateProductRequestDto) {

        validationUtil.validateId(id);

        validationUtil.validateName(updateProductRequestDto.getName());

        ProductEntity prod = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));

        productMapper.updateProduct(updateProductRequestDto, prod);

        productRepository.save(prod);
    }


    public DiscountedPriceResponse getDiscountedPrice(Long id, Integer percent) {

        validationUtil.validateId(id);

        validationUtil.validatePercent(percent);

        ProductEntity prod = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));

        BigDecimal price = prod.getPrice();

        validationUtil.validatePrice(price);

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

        validationUtil.validateName(productName);

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


    public List<ProductResponseDto> getProductsByCategoryId(Long category) {

        validationUtil.validateId(category);

        List<ProductEntity> productEntities = productRepository.findByCategoryId(category);
        return productMapper.productEntitiesToProduct(productEntities);
    }


//    public List<ProductResponseDto> getProductsByCategory(String category, ProductStatus active) {
//
//        validationUtil.validateName(category);
//
//        validationUtil.validateStatus(active);
//
//        List<ProductEntity> productEntities = productRepository.findActiveProductsByCategoryNameAndActive(category, active);
//        return productMapper.productEntitiesToProduct(productEntities);
//    }






}
