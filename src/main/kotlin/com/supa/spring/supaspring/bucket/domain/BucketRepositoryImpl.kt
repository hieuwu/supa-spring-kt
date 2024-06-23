package com.supa.spring.supaspring.bucket.domain

import com.supa.spring.supaspring.controller.dto.BucketDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Repository

@Repository
class BucketRepositoryImpl(
    supabase: SupabaseClient
): BucketRepository {
    val storage: Storage = supabase.storage

    override fun getBuckets(): List<BucketDto> {
        val result = runBlocking {
            storage.retrieveBuckets().map {
                BucketDto(
                    createdAt = it.createdAt,
                    id = it.id,
                    name = it.name,
                    owner = it.owner,
                    updatedAt = it.updatedAt,
                    public = it.public,
                    allowedMimeTypes = it.allowedMimeTypes,
                    fileSizeLimit = it.fileSizeLimit
                )
            }
        }
        return result
    }

    override fun getBucketDetails(bucketId: String): BucketDto? {
        val result = runBlocking {
            val bucket = storage.retrieveBucketById(bucketId)
            bucket?.run {
                BucketDto(
                    createdAt = createdAt,
                    id = id,
                    name = name,
                    owner = owner,
                    updatedAt = updatedAt,
                    public = public,
                    allowedMimeTypes = allowedMimeTypes,
                    fileSizeLimit = fileSizeLimit
                )
            }
        }
        return result
    }

    override fun createBucket(bucketId: String) {
        runBlocking {
            storage.createBucket(bucketId)
        }
    }

    override fun updateBucket(bucketId: String) {
        val result = runBlocking {
            storage.updateBucket(bucketId) {
            }
        }
    }

    override fun deleteBucket(bucketId: String) {
        val result = runBlocking {
            storage.deleteBucket(bucketId)
        }
    }

    override fun emptyBucket(bucketId: String) {
        runBlocking {
            storage.emptyBucket(bucketId)
        }
    }
}