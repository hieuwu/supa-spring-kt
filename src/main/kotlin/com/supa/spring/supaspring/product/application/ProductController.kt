package com.supa.spring.supaspring.product.application

import com.supa.spring.supaspring.product.application.dto.ProductDto
import com.supa.spring.supaspring.product.domain.ProductService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getProducts(): ResponseEntity<List<ProductDto>> {
        val result = productService.getProducts()
        return ResponseEntity<List<ProductDto>>(result, HttpStatusCode.valueOf(200))
    }

    @PostMapping
    fun createProduct(
        @RequestBody product: ProductDto
    ): ResponseEntity<ProductDto> {
        val result = productService.createProduct(product)
        return ResponseEntity<ProductDto>(result, HttpStatusCode.valueOf(200))
    }

    @PostMapping("/image")
    fun uploadImage(
        @RequestBody product: MultipartFile
    ): ResponseEntity<Unit> {
        val result = productService.uploadFile(product)
        return ResponseEntity<Unit>(result, HttpStatusCode.valueOf(200))
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody product: ProductDto) {
        productService.updateProduct(id, product.name, product.price)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String): ResponseEntity<Unit> {
        productService.deleteProduct(id)
        return ResponseEntity<Unit>(HttpStatusCode.valueOf(200))
    }
}