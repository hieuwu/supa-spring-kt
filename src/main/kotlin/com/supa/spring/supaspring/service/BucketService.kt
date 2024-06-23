package com.supa.spring.supaspring.service

import com.supa.spring.supaspring.controller.dto.BucketDto
import com.supa.spring.supaspring.bucket.domain.BucketRepository
import org.springframework.stereotype.Service

@Service
class BucketService(
    val bucketRepositoryImpl: BucketRepository
) {
    fun getBuckets(): List<BucketDto> {
        return bucketRepositoryImpl.getBuckets()
    }

    fun getBucketDetails(bucketId: String): BucketDto? {
        return bucketRepositoryImpl.getBucketDetails(bucketId)
    }

    fun createBucket(bucketId: String) {
        bucketRepositoryImpl.createBucket(bucketId)
    }

    fun updateBucket(bucketId: String) {
        bucketRepositoryImpl.updateBucket(bucketId)
    }

    fun deleteBucket(bucketId: String) {
        bucketRepositoryImpl.deleteBucket(bucketId)
    }

    fun emptyBucket(bucketId: String) {
        bucketRepositoryImpl.emptyBucket(bucketId)
    }
}