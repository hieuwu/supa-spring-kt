package com.supa.spring.supaspring.product.domain

import com.supa.spring.supaspring.product.application.dto.ProductDto
import org.springframework.web.multipart.MultipartFile

interface PostgresProductRepository {
    fun getProducts(): List<ProductDto>
    fun createProduct(product: ProductDto): ProductDto
    fun uploadFile(image: MultipartFile)
    fun updateProduct(id: String, name: String, price: Long): ProductDto
    fun deleteProduct(id: String): Boolean
}