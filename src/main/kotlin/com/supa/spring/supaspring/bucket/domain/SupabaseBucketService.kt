package com.supa.spring.supaspring.bucket.domain

import com.supa.spring.supaspring.bucket.application.BucketDto
import org.springframework.stereotype.Service

@Service
class SupabaseBucketService(
    val bucketRepositoryImpl: BucketRepository
): BucketService {
    override fun getBuckets(): List<BucketDto> {
        return bucketRepositoryImpl.getBuckets()
    }

    override fun getBucketDetails(bucketId: String): BucketDto? {
        return bucketRepositoryImpl.getBucketDetails(bucketId)
    }

    override fun createBucket(bucketId: String) {
        bucketRepositoryImpl.createBucket(bucketId)
    }

    override fun updateBucket(bucketId: String) {
        bucketRepositoryImpl.updateBucket(bucketId)
    }

    override fun deleteBucket(bucketId: String) {
        bucketRepositoryImpl.deleteBucket(bucketId)
    }

    override fun emptyBucket(bucketId: String) {
        bucketRepositoryImpl.emptyBucket(bucketId)
    }
}