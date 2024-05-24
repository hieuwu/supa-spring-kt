package com.supa.spring.supaspring.controller

import com.supa.spring.supaspring.controller.dto.ProductDto
import com.supa.spring.supaspring.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getProducts() {
        productService.getProducts()
    }

    @PostMapping("/{id}")
    fun createProduct(@PathVariable id: Int) {
        productService.createProduct(id)

    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody product: ProductDto) {
        productService.updateProduct()
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int) {
        productService.deleteProduct(id)
    }
}