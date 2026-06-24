package com.example.product_managementapi.service

import com.example.product_managementapi.dto.request.ProductRequestDto
import com.example.product_managementapi.dto.request.UpdateProductRequestDto
import com.example.product_managementapi.dto.response.ProductResponseDto
import com.example.product_managementapi.entity.ProductEntity
import spock.lang.Specification

class ProductServiceTest extends Specification {
    def productRepository = Mock(ProductRepository)
    def productMapper = Mock(ProductMapper)
    def validationUtil = Mock(ValidationUtil)

    def productService = new ProductService(
            productRepository,
            productMapper,
            validationUtil
    )

    // ---------------- CREATE PRODUCT ----------------

    def "should create product successfully"() {
        given:
        def request = new ProductRequestDto(productName: "Phone")
        def entity = new ProductEntity(name: "Phone")
        def savedEntity = new ProductEntity(id: 1L, name: "Phone")
        def response = new ProductResponseDto(1L, "Phone")

        when:
        def result = productService.createProduct(request)

        then:
        1 * validationUtil.validateName("Phone")
        1 * productMapper.productToProductEntity(request) >> entity
        1 * productRepository.save(entity) >> savedEntity
        1 * productMapper.productEntityToProduct(savedEntity) >> response

        result.id == 1L
        result.name == "Phone"
    }

    // ---------------- DELETE PRODUCT ----------------

    def "should delete product when exists"() {
        given:
        def product = new ProductEntity(id: 1L)

        when:
        productService.deleteProduct(1L)

        then:
        1 * validationUtil.validateId(1L)
        1 * productRepository.findById(1L) >> Optional.of(product)
        1 * productRepository.delete(product)
    }

    def "should throw exception when product not found on delete"() {
        when:
        productService.deleteProduct(1L)

        then:
        1 * validationUtil.validateId(1L)
        1 * productRepository.findById(1L) >> Optional.empty()
        thrown(NotFoundException)
    }

    // ---------------- GET BY ID ----------------

    def "should return product by id"() {
        given:
        def entity = new ProductEntity(id: 1L, name: "Laptop")
        def response = new ProductResponseDto(1L, "Laptop")

        when:
        def result = productService.getProductById(1L)

        then:
        1 * validationUtil.validateId(1L)
        1 * productRepository.findById(1L) >> Optional.of(entity)
        1 * productMapper.productEntityToProduct(entity) >> response

        result.name == "Laptop"
    }

    def "should throw exception when product not found by id"() {
        when:
        productService.getProductById(1L)

        then:
        1 * validationUtil.validateId(1L)
        1 * productRepository.findById(1L) >> Optional.empty()
        thrown(NotFoundException)
    }

    // ---------------- UPDATE PRODUCT ----------------

    def "should update product successfully"() {
        given:
        def id = 1L
        def request = new UpdateProductRequestDto(name: "Updated")
        def entity = new ProductEntity(id: 1L, name: "Old")

        when:
        productService.updateProduct(id, request)

        then:
        1 * validationUtil.validateId(id)
        1 * validationUtil.validateName("Updated")
        1 * productRepository.findById(id) >> Optional.of(entity)
        1 * productMapper.updateProduct(request, entity)
        1 * productRepository.save(entity)
    }

    def "should throw exception when updating missing product"() {
        given:
        def id = 1L
        def request = new UpdateProductRequestDto(name: "Updated")

        when:
        productService.updateProduct(id, request)

        then:
        1 * validationUtil.validateId(id)
        1 * validationUtil.validateName("Updated")
        1 * productRepository.findById(id) >> Optional.empty()
        thrown(NotFoundException)
    }

    // ---------------- DISCOUNT PRICE ----------------

    def "should calculate discounted price correctly"() {
        given:
        def product = new ProductEntity(id: 1L, name: "TV", price: 100G)

        when:
        def result = productService.getDiscountedPrice(1L, 10)

        then:
        1 * validationUtil.validateId(1L)
        1 * validationUtil.validatePercent(10)
        1 * productRepository.findById(1L) >> Optional.of(product)
        1 * validationUtil.validatePrice(100G)

        result.id == 1L
        result.name == "TV"
        result.originalPrice == 100G
        result.discountPercent == 10
        result.discountedPrice == 90G
    }

    def "should throw exception when product not found for discount"() {
        when:
        productService.getDiscountedPrice(1L, 10)

        then:
        1 * validationUtil.validateId(1L)
        1 * validationUtil.validatePercent(10)
        1 * productRepository.findById(1L) >> Optional.empty()
        thrown(NotFoundException)
    }

    // ---------------- FIND BY NAME ----------------

    def "should find products by name"() {
        given:
        def entities = [
                new ProductEntity(id: 1L, name: "Phone"),
                new ProductEntity(id: 2L, name: "Phone Pro")
        ]

        def dtos = [
                new ProductResponseDto(1L, "Phone"),
                new ProductResponseDto(2L, "Phone Pro")
        ]

        when:
        def result = productService.findByName("Phone")

        then:
        1 * validationUtil.validateName("Phone")
        1 * productRepository.findByNameContainingIgnoreCase("Phone") >> entities
        1 * productMapper.productEntitiesToProduct(entities) >> dtos

        result.size() == 2
    }

    // ---------------- FILTER BY PRICE ----------------

    def "should filter products by price range"() {
        given:
        def min = 10G
        def max = 100G

        def entities = [
                new ProductEntity(id: 1L, price: 50G),
                new ProductEntity(id: 2L, price: 80G)
        ]

        def dtos = [
                new ProductResponseDto(1L, "A"),
                new ProductResponseDto(2L, "B")
        ]

        when:
        def result = productService.filterByPriceBetween(min, max)

        then:
        1 * productRepository.findByPriceBetween(min, max) >> entities
        1 * productMapper.productEntitiesToProduct(entities) >> dtos

        result.size() == 2
    }

    // ---------------- CATEGORY ----------------

    def "should get products by category"() {
        given:
        def categoryId = 1L
        def entities = [new ProductEntity(id: 1L)]

        def dtos = [new ProductResponseDto(1L, "Product")]

        when:
        def result = productService.getProductsByCategoryId(categoryId)

        then:
        1 * validationUtil.validateId(categoryId)
        1 * productRepository.findByCategoryId(categoryId) >> entities
        1 * productMapper.productEntitiesToProduct(entities) >> dtos
    }
}
