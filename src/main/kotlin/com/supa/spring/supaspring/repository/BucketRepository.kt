package com.supa.spring.supaspring.repository

import com.fasterxml.jackson.annotation.JsonProperty
import com.supa.spring.supaspring.controller.dto.BucketDto
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.Instant
import org.springframework.stereotype.Repository

@Repository
class BucketRepository(
    supabase: SupabaseClient
) {
    val storage: Storage = supabase.storage

    fun getBuckets(): List<BucketDto> {
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

    fun getBucketDetails(bucketId: String): BucketDto? {
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

    fun createBucket(bucketId: String) {
        runBlocking {
            storage.createBucket(bucketId)
        }
    }

    fun updateBucket(bucketId: String) {
        val result = runBlocking {
            storage.updateBucket(bucketId) {
            }
        }
    }

    fun deleteBucket(bucketId: String) {
        val result = runBlocking {
            storage.deleteBucket(bucketId)
        }
    }

    fun emptyBucket(bucketId: String) {
        runBlocking {
            storage.emptyBucket(bucketId)
        }
    }
}