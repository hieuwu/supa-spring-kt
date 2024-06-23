package com.supa.spring.supaspring.file.infrastructure

import com.supa.spring.supaspring.file.application.BucketItemDto
import com.supa.spring.supaspring.file.domain.FileRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository

@Repository
class SupabaseFileRepository(
    supabase: SupabaseClient
): FileRepository {
    val storage: Storage = supabase.storage

    override fun getFilesInBucket(bucketId: String): List<BucketItemDto> {
        val result = runBlocking {
            storage.from(bucketId).list().map {
                BucketItemDto(
                    name = it.name,
                    id = it.id,
                    updatedAt = it.updatedAt,
                    createdAt = it.createdAt,
                    lastAccessedAt = it.lastAccessedAt,
                    metadata = it.metadata
                )
            }
        }
        return result
    }
}