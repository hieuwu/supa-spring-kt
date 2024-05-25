package com.supa.spring.supaspring.repository

import com.supa.spring.supaspring.controller.dto.ProductDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.serializer.JacksonSerializer
import io.ktor.util.logging.*
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository

class ProductRepository constructor
    (
    supabase: SupabaseClient = createSupabaseClient(
        supabaseUrl = "https://tyjxzodfrahibdkhgquy.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR5anh6b2RmcmFoaWJka2hncXV5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODUxMTM2MDcsImV4cCI6MjAwMDY4OTYwN30.rXN-_rGEHKjOlo75xoDYOPkshrno9rK7h1H-CXFb2_g"
    ) {
        install(Auth)
        install(Postgrest)
        defaultSerializer = JacksonSerializer()
    },
    val logger: Logger = LoggerFactory.getLogger(ProductRepository::class.java),
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
) {

    val postgrest: Postgrest = supabase.postgrest

    fun getProducts(): List<ProductDto> {
        val result: List<ProductDto> = runBlocking {
            postgrest["products"].select().decodeList<ProductDto>()
        }
        return result
    }

    fun createProduct(product: ProductDto): ProductDto {
        val result = runBlocking {
            postgrest["products"].insert(product) {
                select()
            }
        }
        return result.decodeSingle()
    }

    fun updateProduct(): ProductDto {
        return ProductDto(
            id = "1",
            name = "Product namne",
            price = 23, ""
        )
    }

    fun deleteProduct(id: String): Boolean {
        runBlocking {
            postgrest["products"].delete {
                filter {
                    eq("id", id)
                }
            }
        }
        return true
    }
}