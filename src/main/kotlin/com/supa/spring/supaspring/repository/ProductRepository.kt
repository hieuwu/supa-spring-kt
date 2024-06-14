package com.supa.spring.supaspring.repository

import com.supa.spring.supaspring.controller.dto.ProductDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository
import org.springframework.web.multipart.MultipartFile

@Repository
class ProductRepository(supabase: SupabaseClient) {

    val postgrest: Postgrest = supabase.postgrest
    val storage: Storage = supabase.storage

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

    fun uploadFile(image: MultipartFile) {
        runBlocking {
            storage.from("images").upload(
                path = image.originalFilename?.replace(" ", "_") ?: "noname",
                data = image.bytes,
                upsert = false,
            )
        }
    }

    fun updateProduct(id: String, name: String, price: Long): ProductDto {
        val result = runBlocking {
            postgrest["products"].update({
                set("name", name)
                set("price", price)
            }) {
                filter {
                    eq("id", id)
                }
                select()
            }
        }
        return result.decodeSingle()
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