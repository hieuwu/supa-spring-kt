package com.supa.spring.supaspring.service

import com.supa.spring.supaspring.controller.dto.ProductDto
import com.supa.spring.supaspring.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository
) {

    fun getProducts(): List<ProductDto> {
        return productRepository.getProducts()
    }

    fun createProduct(id: Int) {

    }

    fun updateProduct() {

    }

    fun deleteProduct(id: Int) {

    }
}