package com.supa.spring.supaspring.product.domain

import com.supa.spring.supaspring.product.application.dto.ProductDto
import com.supa.spring.supaspring.product.infrastructure.PostgrestProductRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ProductService(
    val postgrestProductRepository: PostgrestProductRepository
) {

    fun getProducts(): List<ProductDto> {
        return postgrestProductRepository.getProducts()
    }

    fun createProduct(product: ProductDto): ProductDto {
        return postgrestProductRepository.createProduct(product)
    }

    fun uploadFile(file: MultipartFile) {
        return postgrestProductRepository.uploadFile(file)
    }

    fun updateProduct(id: String, name: String, price: Long) {
        postgrestProductRepository.updateProduct(id, name, price)
    }

    fun deleteProduct(id: String) {
        postgrestProductRepository.deleteProduct(id)
    }
}