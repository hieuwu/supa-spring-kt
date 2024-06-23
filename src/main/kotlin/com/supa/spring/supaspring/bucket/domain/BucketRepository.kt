package com.supa.spring.supaspring.bucket.domain

import com.supa.spring.supaspring.controller.dto.BucketDto

interface BucketRepository {
    fun getBuckets(): List<BucketDto>
    fun getBucketDetails(bucketId: String): BucketDto?
    fun createBucket(bucketId: String)
    fun updateBucket(bucketId: String)
    fun deleteBucket(bucketId: String)
    fun emptyBucket(bucketId: String)
}