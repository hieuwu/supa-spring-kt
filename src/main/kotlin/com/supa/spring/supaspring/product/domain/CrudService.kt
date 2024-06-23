package com.supa.spring.supaspring.product.domain

import com.supa.spring.supaspring.product.application.dto.ProductDto
import org.springframework.web.multipart.MultipartFile

interface CrudService {
    fun getProducts(): List<ProductDto>
    fun createProduct(product: ProductDto): ProductDto
    fun uploadFile(file: MultipartFile)
    fun updateProduct(id: String, name: String, price: Long)
    fun deleteProduct(id: String)
}