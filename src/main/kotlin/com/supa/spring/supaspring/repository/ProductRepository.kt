package com.supa.spring.supaspring.repository

import com.supa.spring.supaspring.controller.dto.ProductDto
import org.springframework.stereotype.Repository

@Repository
class ProductRepository {

    fun getProducts(): List<ProductDto> {
        return listOf(
            ProductDto(
                id = 1,
                name = "Product namne",
                price = 23
            )
        )
    }

    fun createProduct(id: Int): ProductDto {
        return ProductDto(
            id = 1,
            name = "Product namne",
            price = 23
        )
    }

    fun updateProduct(): ProductDto {
        return ProductDto(
            id = 1,
            name = "Product namne",
            price = 23
        )
    }

    fun deleteProduct(id: Int): Boolean {
        return true
    }
}